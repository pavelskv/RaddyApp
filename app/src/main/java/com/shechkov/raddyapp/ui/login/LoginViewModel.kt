package com.shechkov.raddyapp.ui.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shechkov.raddyapp.R
import com.shechkov.raddyapp.core.UiValidatorChain
import com.shechkov.raddyapp.domain.login.LoginInteractor
import com.shechkov.raddyapp.ui.login.validator.EmptinessValidator
import com.shechkov.raddyapp.ui.login.validator.MinLengthValidator
import kotlinx.coroutines.*
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val interactor: LoginInteractor
) : ViewModel() {

    val loginState = MutableLiveData<InputState>()
    val passwordState = MutableLiveData<InputState>()
    val progressState = MutableLiveData<Boolean>()
    val messageState = MutableLiveData<Boolean>()

    private val passwordMinLength = 4

    private val emptinessValidator by lazy {
        EmptinessValidator(R.string.empty_string_error_message)
    }

    private val passwordValidators by lazy {
        UiValidatorChain(
            emptinessValidator,
            MinLengthValidator(R.string.invalid_min_length_error_message, passwordMinLength)
        )
    }

    fun login(login: String, password: String) {
        var success = true
        if (!emptinessValidator.isValid(login)) {
            loginState.value = InputState(true, emptinessValidator.errorMessage)
            success = false
        }
        if (!passwordValidators.isValid(password)) {
            passwordState.value = InputState(true, passwordValidators.errorMessage)
            success = false
        }
        if (success) {
            progressState.value = true
            viewModelScope.launch(Dispatchers.IO) {
                messageState.postValue(interactor.login(login, password))
                progressState.postValue(false)
            }
        }
    }

    fun clearLoginError() {
        loginState.value = InputState()
    }

    fun clearPasswordError() {
        passwordState.value = InputState()
    }

    data class InputState(
        val containsError: Boolean = false,
        val errorMessage: Int = R.string.empty
    )
}
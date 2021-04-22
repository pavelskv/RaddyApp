package com.shechkov.raddyapp.ui.login.validator

import androidx.annotation.StringRes
import com.shechkov.raddyapp.core.UiValidator

open class MinLengthValidator(
    @StringRes override val errorMessage: Int,
    private val minLength: Int
) : UiValidator {

    override fun isValid(text: String): Boolean {
        return text.length >= minLength
    }
}
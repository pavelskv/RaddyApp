package com.shechkov.raddyapp.domain.login

import javax.inject.Inject

class LoginInteractorImpl @Inject constructor(private val repository: LoginRepository): LoginInteractor {

    override suspend fun login(login: String, password: String): Boolean = repository.login(login, password)
}
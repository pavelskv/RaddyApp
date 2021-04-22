package com.shechkov.raddyapp.domain.login

interface LoginInteractor {

    suspend fun login(login: String, password: String): Boolean

}
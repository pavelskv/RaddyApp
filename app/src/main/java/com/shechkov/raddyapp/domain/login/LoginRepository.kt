package com.shechkov.raddyapp.domain.login

interface LoginRepository {

    suspend fun login(login: String, password: String): Boolean
}
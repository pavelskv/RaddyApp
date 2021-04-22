package com.shechkov.raddyapp.data.login

import com.shechkov.raddyapp.domain.login.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api: TestApiHelper
) : LoginRepository {

    override suspend fun login(login: String, password: String): Boolean = api.login(login, password)

}
package com.shechkov.raddyapp.data.login

class TestApiHelper {

    fun login(login: String, password: String): Boolean {
        Thread.sleep(3000)
        return login == "test" && password == "12345"
    }

}

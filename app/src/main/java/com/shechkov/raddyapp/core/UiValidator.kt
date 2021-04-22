package com.shechkov.raddyapp.core

interface UiValidator {

    val errorMessage: Int

    fun isValid(text: String): Boolean

}
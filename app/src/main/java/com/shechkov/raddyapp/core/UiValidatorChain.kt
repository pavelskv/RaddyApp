package com.shechkov.raddyapp.core

class UiValidatorChain(
    private val base: UiValidator,
    private val next: UiValidator
) : UiValidator {

    private var baseValid = false

    override fun isValid(text: String): Boolean {
        baseValid = base.isValid(text)
        return if (baseValid) next.isValid(text) else false
    }

    override val errorMessage: Int
        get() = if (baseValid) next.errorMessage else base.errorMessage
}
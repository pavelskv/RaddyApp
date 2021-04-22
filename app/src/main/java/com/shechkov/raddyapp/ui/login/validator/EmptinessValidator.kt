package com.shechkov.raddyapp.ui.login.validator

import androidx.annotation.StringRes

class EmptinessValidator(@StringRes override val errorMessage: Int) : MinLengthValidator(errorMessage, 1)
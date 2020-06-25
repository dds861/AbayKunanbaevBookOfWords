package com.dd.domain.exception



data class LoginException(override val message:String= "Login failed, please retry it") : Exception()
package com.dd.domain.exception


data class PasswordEmptyException(override val message:String= "Password cannot be empty") : Exception()
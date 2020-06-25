package com.dd.domain.exception

data class UserEmptyException(override val message:String= "User cannot be empty") : Exception()
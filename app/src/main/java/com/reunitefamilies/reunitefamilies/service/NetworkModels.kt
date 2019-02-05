package com.reunitefamilies.reunitefamilies.service

data class RegisterRequestBody(
    val email: String,
    val password: String,
    val name: String,
    val location: String,
    val languages: String
)

data class LoginRequestBody(
    val email: String,
    val password: String
)
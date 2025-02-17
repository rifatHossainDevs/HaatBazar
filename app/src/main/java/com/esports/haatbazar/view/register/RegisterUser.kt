package com.esports.haatbazar.view.register

data class RegisterUser(
    val name: String,
    val email: String,
    val password: String,
    val userType: String,
    var userId: String,
)

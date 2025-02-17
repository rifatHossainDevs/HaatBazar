package com.esports.haatbazar.data

import com.esports.haatbazar.view.forgetPassword.ForgetPasswordUser
import com.esports.haatbazar.view.login.LoginUser
import com.esports.haatbazar.view.register.RegisterUser
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthSource {

    fun userRegistration(user: RegisterUser): Task<AuthResult>

    fun userLogin(user: LoginUser): Task<AuthResult>

    fun userForgetPassword(user: ForgetPasswordUser): Task<Void>

    fun createUser(user: RegisterUser): Task<Void>
}
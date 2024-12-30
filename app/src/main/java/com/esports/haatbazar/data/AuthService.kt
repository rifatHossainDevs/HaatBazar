package com.esports.haatbazar.data

import com.esports.haatbazar.view.login.LoginUser
import com.esports.haatbazar.view.register.RegisterUser
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class AuthService : AuthSource {
    override fun userRegistration(user: RegisterUser): Task<AuthResult> {
        val mAuth = FirebaseAuth.getInstance()
        return mAuth.createUserWithEmailAndPassword(user.email, user.password)
    }

    override fun userLogin(user: LoginUser): Task<AuthResult> {
        val mAuth = FirebaseAuth.getInstance()
        return mAuth.signInWithEmailAndPassword(user.email, user.password)
    }
}
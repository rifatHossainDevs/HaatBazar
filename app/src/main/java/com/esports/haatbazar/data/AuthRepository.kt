package com.esports.haatbazar.data

import com.esports.haatbazar.core.Nodes
import com.esports.haatbazar.view.forgetPassword.ForgetPasswordUser
import com.esports.haatbazar.view.login.LoginUser
import com.esports.haatbazar.view.register.RegisterUser
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class AuthRepository @Inject constructor(private val mAuth: FirebaseAuth, private val db: FirebaseFirestore) : AuthSource {
    override fun userRegistration(user: RegisterUser): Task<AuthResult> {
        return mAuth.createUserWithEmailAndPassword(user.email, user.password)
    }

    override fun userLogin(user: LoginUser): Task<AuthResult> {
        return mAuth.signInWithEmailAndPassword(user.email, user.password)
    }

    override fun userForgetPassword(user: ForgetPasswordUser): Task<Void> {
        return mAuth.sendPasswordResetEmail(user.email)
    }

    override fun createUser(user: RegisterUser): Task<Void> {
        return db.collection(Nodes.USER).document(user.userId).set(user)
    }


}
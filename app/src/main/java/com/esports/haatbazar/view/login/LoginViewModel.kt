package com.esports.haatbazar.view.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esports.haatbazar.core.DataState
import com.esports.haatbazar.data.AuthService

class LoginViewModel: ViewModel() {

    private val _loginResponce = MutableLiveData<DataState<LoginUser>>()

    val loginResponce: MutableLiveData<DataState<LoginUser>> = _loginResponce

    fun loginUser(user: LoginUser){
        _loginResponce.postValue(DataState.Loading())

        val authService = AuthService()

        authService.userLogin(user).addOnSuccessListener {
            _loginResponce.postValue(DataState.Success(user))
            Log.d("TAG", "loginUser: Success")
        }.addOnFailureListener {
            _loginResponce.postValue(DataState.Error(it.message))
            Log.d("TAG", "loginUser: ${it.message}")
        }

    }

}
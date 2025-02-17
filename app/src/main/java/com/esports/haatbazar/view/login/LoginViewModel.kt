package com.esports.haatbazar.view.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esports.haatbazar.core.DataState
import com.esports.haatbazar.data.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authService: AuthRepository): ViewModel() {

    private val _loginResponce = MutableLiveData<DataState<LoginUser>>()

    val loginResponce: MutableLiveData<DataState<LoginUser>> = _loginResponce

    fun loginUser(user: LoginUser){
        _loginResponce.postValue(DataState.Loading())

        authService.userLogin(user).addOnSuccessListener {
            _loginResponce.postValue(DataState.Success(user))
            Log.d("TAG", "loginUser: Success")
        }.addOnFailureListener {
            _loginResponce.postValue(DataState.Error(it.message))
            Log.d("TAG", "loginUser: ${it.message}")
        }

    }

}
package com.esports.haatbazar.view.forgetPassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esports.haatbazar.core.DataState
import com.esports.haatbazar.data.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgetPasswordViewModel @Inject constructor(private val authService: AuthRepository) : ViewModel() {
    private val _forgetPasswordResponse = MutableLiveData<DataState<ForgetPasswordUser>>()

    val forgetPasswordResponse: MutableLiveData<DataState<ForgetPasswordUser>> = _forgetPasswordResponse

    fun forgetPasswordUser(user: ForgetPasswordUser) {
        _forgetPasswordResponse.postValue(DataState.Loading())

        authService.userForgetPassword(user).addOnSuccessListener {
            _forgetPasswordResponse.postValue(DataState.Success(user))
        }.addOnFailureListener {
            _forgetPasswordResponse.postValue(DataState.Error(it.message))
        }
    }
}
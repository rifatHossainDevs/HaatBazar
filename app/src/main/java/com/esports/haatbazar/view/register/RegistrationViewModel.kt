package com.esports.haatbazar.view.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esports.haatbazar.core.DataState
import com.esports.haatbazar.data.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val authRepository: AuthRepository) :
    ViewModel() {
    private val _registrationResponce = MutableLiveData<DataState<RegisterUser>>()

    val registrationResponce: MutableLiveData<DataState<RegisterUser>> = _registrationResponce

    fun userRegister(user: RegisterUser) {
        _registrationResponce.postValue(DataState.Loading())

        authRepository.userRegistration(user).addOnSuccessListener {

            it.user?.let { createdUser ->

                user.userId = createdUser.uid

                authRepository.createUser(user).addOnSuccessListener {
                    _registrationResponce.postValue(DataState.Success(user))

                }.addOnFailureListener {
                    _registrationResponce.postValue(DataState.Error(it.message))
                }
            }

        }.addOnFailureListener {
            _registrationResponce.postValue(DataState.Error(it.message))


        }
    }
}
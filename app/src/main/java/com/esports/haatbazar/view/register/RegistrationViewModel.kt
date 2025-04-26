package com.esports.haatbazar.view.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esports.haatbazar.core.DataState
import com.esports.haatbazar.data.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val authRepository: AuthRepository) :
    ViewModel() {
    private val _registrationResponse = MutableLiveData<DataState<RegisterUser>>()

    val registrationResponse: LiveData<DataState<RegisterUser>> = _registrationResponse

    fun userRegister(user: RegisterUser) {
        _registrationResponse.postValue(DataState.Loading())

        authRepository.userRegistration(user).addOnSuccessListener {

            it.user?.let { createdUser ->

                user.userId = createdUser.uid

                authRepository.createUser(user).addOnSuccessListener {
                    _registrationResponse.postValue(DataState.Success(user))

                }.addOnFailureListener {
                    _registrationResponse.postValue(DataState.Error(it.message))
                }
            }

        }.addOnFailureListener {
            _registrationResponse.postValue(DataState.Error(it.message))


        }
    }
}
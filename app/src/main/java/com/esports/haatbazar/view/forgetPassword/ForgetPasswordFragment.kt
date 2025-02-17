package com.esports.haatbazar.view.forgetPassword

import android.util.Patterns
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.esports.haatbazar.Base.BaseFragment
import com.esports.haatbazar.R
import com.esports.haatbazar.core.DataState
import com.esports.haatbazar.databinding.FragmentForgetPasswordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgetPasswordFragment :
    BaseFragment<FragmentForgetPasswordBinding>(FragmentForgetPasswordBinding::inflate) {
    private val viewModel: ForgetPasswordViewModel by viewModels()
    override fun setAllClickListener() {
        setClickListener()
    }

    override fun allObserver() {
        forgetPasswordObserver()
    }

    private fun forgetPasswordObserver() {
        viewModel.forgetPasswordResponse.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Error -> {
                    Toast.makeText(context, "${it.message}", Toast.LENGTH_SHORT).show()
                    loading.dismiss()
                }

                is DataState.Loading -> {
                    Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show()
                    loading.show()
                }

                is DataState.Success -> {
                    Toast.makeText(context, "Send Email Successfully", Toast.LENGTH_SHORT).show()
                    loading.dismiss()
                    findNavController().navigate(R.id.action_ForgetPasswordFragment_to_loginFragment)
                }
            }
        }
    }

    private fun setClickListener() {
        binding.btnForgetPassword.setOnClickListener {
            checkAllFieldValidity()
            val email = binding.etEmail.text.toString()
            if (checkAllFieldValidity()) {
                val user = ForgetPasswordUser(email)
                viewModel.forgetPasswordUser(user)

            }
        }
    }

    private fun checkAllFieldValidity(): Boolean {
        val email = binding.etEmail.text.toString()

        if (email == "") {
            binding.emailInputLayout.error = "This field must be filled"
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailInputLayout.error = "Email format is invalid"
            return false
        }
        return true
    }
}
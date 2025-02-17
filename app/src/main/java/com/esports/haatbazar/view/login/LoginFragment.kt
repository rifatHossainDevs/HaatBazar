package com.esports.haatbazar.view.login

import android.util.Patterns
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.esports.haatbazar.Base.BaseFragment
import com.esports.haatbazar.R
import com.esports.haatbazar.core.DataState
import com.esports.haatbazar.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel: LoginViewModel by viewModels()

    override fun setAllClickListener() {
        setClickListener()
    }

    override fun allObserver() {
        loginObserver()
    }

    private fun loginObserver() {
        viewModel.loginResponce.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Error -> {
                    Toast.makeText(context, "Email and Password Does not match", Toast.LENGTH_SHORT).show()
                    loading.dismiss()
                }
                is DataState.Loading -> {
                    Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT)
                        .show()
                    loading.show()
                }

                is DataState.Success -> {
                    Toast.makeText(context, "Login Successful...", Toast.LENGTH_SHORT).show()
                    loading.dismiss()
                    findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                }
            }
        }
    }

    private fun setClickListener() {
        binding.btnLogin.setOnClickListener {
            checkAllfieldValidity()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            if (checkAllfieldValidity()) {
                val user = LoginUser(email, password)
                viewModel.loginUser(user)
            }
        }

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.forgetPasswordTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_ForgetPasswordFragment)
        }
    }

    private fun checkAllfieldValidity(): Boolean {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if (email == "") {
            binding.emailInputLayout.error = "This field must be filled"
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailInputLayout.error = "Email format is invalid"
            return false
        }
        if (password == "") {
            binding.passwordInputLayout.error = "This field must be filled"
            return false
        }
        if (password.length < 8) {
            binding.passwordInputLayout.error = "Password Should have at least 8 Character"
            return false
        }
        return true
    }

}
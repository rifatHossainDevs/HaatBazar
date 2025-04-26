package com.esports.haatbazar.view.register

import android.annotation.SuppressLint
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.esports.haatbazar.Base.BaseFragment
import com.esports.haatbazar.R
import com.esports.haatbazar.core.DataState
import com.esports.haatbazar.databinding.FragmentRegisterBinding
import com.google.android.material.button.MaterialButtonToggleGroup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    val viewModel: RegistrationViewModel by viewModels()

    override fun setAllClickListener() {
        setClickListener()
    }

    override fun allObserver() {
        registrationObserver()
    }

    private fun registrationObserver() {
        viewModel.registrationResponse.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Error -> {
                    Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
                    loading.dismiss()
                }

                is DataState.Loading -> {
                    Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT)
                        .show()
                    loading.show()
                }

                is DataState.Success -> {
                    Toast.makeText(
                        context,
                        "Registration Successful for ${it.Data}",
                        Toast.LENGTH_SHORT
                    ).show()
                    loading.dismiss()
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                }
            }
        }
    }

    private fun setClickListener() {
        /*var selectedId: String? = null

        binding.toggleButton.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if (isChecked) {
                selectedId = when (checkedId) {
                    binding.btnCustomer.id -> binding.btnCustomer.text.toString()
                    binding.btnSeller.id -> binding.btnSeller.text.toString()
                    binding.btnAdmin.id -> binding.btnAdmin.text.toString()
                    else -> null
                }
            } else if (selectedId != null && group.checkedButtonId == View.NO_ID) {
                selectedId = null
            }
        }*/

        binding.btnRegister.setOnClickListener {
            checkAllFieldValidity()
            if (checkAllFieldValidity()) {
                //val userType = selectedId ?: "Unknown"
                val user = RegisterUser(
                    binding.etName.text.toString(),
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString(),
                    "Seller",
                    ""
                )
                viewModel.userRegister(user)
            }
        }

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun checkAllFieldValidity(): Boolean {
        val name = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val emailPattern = "^[a-z0-9+_.-]+@[a-z.-]{4,7}\\.[a-z]{2,5}$"
        val passwordPattern =
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#\$%^&*(),.?\":{}|<>~_-]).{8,}\$"
        val toggleButton: MaterialButtonToggleGroup = binding.toggleButton

        if (name == "") {
            binding.nameContainer.error = "This field must be filled"
            return false
        }

        if (email == "") {
            binding.emailContainer.error = "This field must be filled"
            return false
        }
        if (!email.matches(emailPattern.toRegex())) {
            binding.emailContainer.error = "Invalid Email Format"
            return false
        }
        if (password == "") {
            binding.passwordContainer.error = "This field must be filled"
            return false
        }
        if (password.length < 8) {
            binding.passwordContainer.error = "Password Should have at least 8 Characters"
            return false
        }
        if (!password.matches(passwordPattern.toRegex())) {
            binding.passwordContainer.error =
                "At least one capital letter, small letter, digit and symbol"
            return false
        }
        if (toggleButton.checkedButtonIds.isEmpty()) {

            binding.apply {
                errorMessage.visibility = View.VISIBLE
                errorMessage.text = "Please Select an Option"
            }
            return false
        }

        return true
    }

}
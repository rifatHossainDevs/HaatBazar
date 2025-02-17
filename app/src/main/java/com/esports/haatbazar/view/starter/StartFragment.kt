package com.esports.haatbazar.view.starter

import androidx.navigation.fragment.findNavController
import com.esports.haatbazar.Base.BaseFragment
import com.esports.haatbazar.R
import com.esports.haatbazar.databinding.FragmentStartBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate) {

    override fun setAllClickListener() {
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_loginFragment)
        }

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_registerFragment)
        }

        setUpAutoLogin()
    }

    private fun setUpAutoLogin() {
        FirebaseAuth.getInstance().currentUser?.let {
            findNavController().navigate(R.id.action_startFragment_to_dashboardFragment)
        }
    }

    override fun allObserver() {

    }

}
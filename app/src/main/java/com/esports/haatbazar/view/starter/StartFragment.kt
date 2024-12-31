package com.esports.haatbazar.view.starter

import androidx.navigation.fragment.findNavController
import com.esports.haatbazar.Base.BaseFragment
import com.esports.haatbazar.R
import com.esports.haatbazar.databinding.FragmentStartBinding

class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate) {

    override fun setAllClickListener() {
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_loginFragment)
        }

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_registerFragment)
        }
    }

    override fun allObserver() {

    }

}
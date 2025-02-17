package com.esports.haatbazar.view.dashboard

import androidx.navigation.fragment.findNavController
import com.esports.haatbazar.Base.BaseFragment
import com.esports.haatbazar.R
import com.esports.haatbazar.databinding.FragmentDashboardBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SellerDashboardFragment :
    BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {
    val mAuth = FirebaseAuth.getInstance()
    override fun setAllClickListener() {
        binding.apply {
            btnLogout.setOnClickListener {
                mAuth.signOut()
                findNavController().navigate(R.id.action_dashboardFragment_to_startFragment)
            }
        }
    }

    override fun allObserver() {

    }

}
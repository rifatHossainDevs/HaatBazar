package com.esports.haatbazar.Base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.esports.haatbazar.core.DataState

abstract class BaseFragment<VB : ViewBinding>(
    private val bindingInflater: (inflater: LayoutInflater) -> VB,
) : Fragment() {
    private var _binding: VB? = null

    val binding: VB get() = _binding as VB

    lateinit var loading: ProgressDialog
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        loading = ProgressDialog(requireContext())
        setAllClickListener()
        allObserver()

        return binding.root
    }

    abstract fun setAllClickListener()
    abstract fun allObserver()
}
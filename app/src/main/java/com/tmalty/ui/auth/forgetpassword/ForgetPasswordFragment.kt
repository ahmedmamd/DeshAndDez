package com.tmalty.ui.auth.forgetpassword

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.databinding.FragmentForgetPasswordBinding
import com.tmalty.databinding.FragmentSignUpBinding

class ForgetPasswordFragment : BaseFragment(R.layout.fragment_forget_password) {

    // Declare view and objects
    lateinit var binding: FragmentForgetPasswordBinding

    //Departments

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForgetPasswordBinding.bind(requireView())
        binding.lifecycleOwner = this
        setupFragment()
    }


    //Entry point to this fragment
    private fun setupFragment() {
        setupUI()
        setupListeners()
    }

    // Set up the UI components
    private fun setupUI() {
        // Set up any UI-related configurations here
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.llBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnSend.setOnClickListener {
            findNavController().navigate(R.id.action_forgetPasswordFragment_to_forgetPasswordVerificationFragment)
        }
    }
}
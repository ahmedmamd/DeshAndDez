package com.tmalty.ui.auth.forgetpassword

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.databinding.FragmentForgetPasswordBinding
import com.tmalty.databinding.FragmentForgetPasswordVerificationBinding
import com.tmalty.databinding.FragmentSignUpBinding

class ForgetPasswordVerificationFragment :
    BaseFragment(R.layout.fragment_forget_password_verification) {

    // Declare view and objects
    lateinit var binding: FragmentForgetPasswordVerificationBinding

    //Departments

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForgetPasswordVerificationBinding.bind(requireView())
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
        binding.btnConfirm.setOnClickListener {
            findNavController().navigate(R.id.action_forgetPasswordVerificationFragment_to_forgetPasswordResetFragment)
        }
        binding.resendCode.setOnClickListener {
        }
    }
}
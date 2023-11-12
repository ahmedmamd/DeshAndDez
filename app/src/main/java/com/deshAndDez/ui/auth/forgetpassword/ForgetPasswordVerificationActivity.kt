package com.deshAndDez.ui.auth.forgetpassword

import android.os.Bundle
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.commons.extensions.startActivity
import com.deshAndDez.databinding.FragmentForgetPasswordVerificationBinding

class ForgetPasswordVerificationActivity :BaseActivity() {

    // Declare view and objects
    lateinit var binding: FragmentForgetPasswordVerificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentForgetPasswordVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActivity()
    }

    //Entry point to this activity
    private fun setupActivity() {
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
            finish()
        }
        binding.btnConfirm.setOnClickListener {
            startActivity(ForgetPasswordResetActivity::class.java)
        }
        binding.resendCode.setOnClickListener {
        }
    }
}
package com.deshAndDez.ui.auth.create_account

import android.os.Bundle
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.commons.extensions.startActivity
import com.deshAndDez.databinding.FragmentSignUpBinding
import com.deshAndDez.ui.auth.accountverification.VerifyAccountStepOneActivity

class SignUpActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: FragmentSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSignUpBinding.inflate(layoutInflater)
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
        binding.toolbar.back.setOnClickListener {
            finish()
        }
        binding.btnSignUp.setOnClickListener {
            startActivity(VerifyAccountStepOneActivity::class.java)
        }
    }

}
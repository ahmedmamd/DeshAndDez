package com.tmalty.ui.auth.create_account

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.tmalty.R
import com.tmalty.base.BaseActivity
import com.tmalty.commons.extensions.startActivity
import com.tmalty.databinding.FragmentLoginBinding
import com.tmalty.databinding.FragmentSignUpBinding
import com.tmalty.ui.auth.accountverification.VerifyAccountStepOneActivity

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
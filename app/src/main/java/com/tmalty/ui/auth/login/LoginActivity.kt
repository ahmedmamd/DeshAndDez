package com.tmalty.ui.auth.login

import android.os.Bundle
import com.tmalty.base.BaseActivity
import com.tmalty.commons.extensions.startActivity
import com.tmalty.databinding.FragmentLoginBinding
import com.tmalty.ui.auth.create_account.SignUpActivity
import com.tmalty.ui.auth.forgetpassword.ForgetPasswordActivity
import com.tmalty.ui.main.activities.MainActivity

class LoginActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
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
        binding.btnLogin.setOnClickListener {
            startActivity(MainActivity::class.java)
            finishAffinity()
        }
        binding.tvSignUp.setOnClickListener {
            startActivity(SignUpActivity::class.java)
        }
        binding.tvForgotPassword.setOnClickListener {
            startActivity(ForgetPasswordActivity::class.java)
        }
        binding.btnGoogle.setOnClickListener {
        }
    }

}
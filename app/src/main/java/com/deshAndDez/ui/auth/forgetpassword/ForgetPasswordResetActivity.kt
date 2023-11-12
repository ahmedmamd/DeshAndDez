package com.deshAndDez.ui.auth.forgetpassword

import android.os.Bundle
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.commons.extensions.startActivity
import com.deshAndDez.databinding.FragmentForgetPasswordResetBinding
import com.deshAndDez.ui.main.activities.MainActivity

class ForgetPasswordResetActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: FragmentForgetPasswordResetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentForgetPasswordResetBinding.inflate(layoutInflater)
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
            startActivity(MainActivity::class.java)
        }
    }
}
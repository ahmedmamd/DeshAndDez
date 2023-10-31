package com.tmalty.ui.main.addservice

import android.os.Bundle
import com.tmalty.base.BaseActivity
import com.tmalty.commons.extensions.startActivity
import com.tmalty.databinding.ActivityAddServiceStepOneBinding
import com.tmalty.databinding.ActivityAddServiceStepThreeBinding
import com.tmalty.databinding.FragmentLoginBinding
import com.tmalty.ui.auth.create_account.SignUpActivity
import com.tmalty.ui.auth.forgetpassword.ForgetPasswordActivity
import com.tmalty.ui.main.activities.MainActivity

class AddServiceStepThreeActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: ActivityAddServiceStepThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddServiceStepThreeBinding.inflate(layoutInflater)
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
        binding.previousButton.setOnClickListener {
            finish()
        }
        binding.nextButton.setOnClickListener {
            startActivity(MainActivity::class.java)
        }
    }
}
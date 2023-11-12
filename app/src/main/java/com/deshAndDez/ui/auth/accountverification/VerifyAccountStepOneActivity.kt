package com.deshAndDez.ui.auth.accountverification

import android.os.Bundle
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.commons.extensions.startActivity
import com.deshAndDez.databinding.FragmentVerifyAccountStepOneBinding

class VerifyAccountStepOneActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: FragmentVerifyAccountStepOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentVerifyAccountStepOneBinding.inflate(layoutInflater)
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
        binding.nextButton.setOnClickListener {
            startActivity(VerifyAccountStepTwoActivity::class.java)
        }
    }

}
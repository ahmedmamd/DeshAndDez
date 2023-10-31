package com.tmalty.ui.auth.accountverification

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.tmalty.R
import com.tmalty.base.BaseActivity
import com.tmalty.commons.extensions.startActivity
import com.tmalty.databinding.FragmentLoginBinding
import com.tmalty.databinding.FragmentSignUpBinding
import com.tmalty.databinding.FragmentVerifyAccountStepOneBinding
import com.tmalty.databinding.FragmentVerifyAccountStepThreeBinding
import com.tmalty.databinding.FragmentVerifyAccountStepTwoBinding

class VerifyAccountStepThreeActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: FragmentVerifyAccountStepThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentVerifyAccountStepThreeBinding.inflate(layoutInflater)
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
            startActivity(VerifyAccountStepFourActivity::class.java)
        }
    }

}
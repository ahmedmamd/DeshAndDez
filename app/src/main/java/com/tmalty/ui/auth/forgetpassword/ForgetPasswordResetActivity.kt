package com.tmalty.ui.auth.forgetpassword

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.tmalty.R
import com.tmalty.base.BaseActivity
import com.tmalty.base.BaseFragment
import com.tmalty.commons.extensions.startActivity
import com.tmalty.databinding.FragmentForgetPasswordBinding
import com.tmalty.databinding.FragmentForgetPasswordResetBinding
import com.tmalty.ui.main.activities.MainActivity

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
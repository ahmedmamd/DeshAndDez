package com.tmalty.ui.contactus

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.tmalty.base.BaseActivity
import com.tmalty.databinding.ActivityContactUsBinding
import com.tmalty.databinding.ActivityPolicyBinding
import com.tmalty.ui.aboutApp.AboutAppViewModel

class ContactUsActivity : BaseActivity() {
    // Declare view and objects
    private lateinit var binding: ActivityContactUsBinding
    private val aboutAppViewModel : AboutAppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactUsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActivity()
    }

    //Entry point to this activity
    private fun setupActivity() {
        setupUI()
        setUpData()
        setupListeners()
    }

    private fun setUpData() {

    }

    // Set up the UI components
    private fun setupUI() {
    }

    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
    }
}
package com.deshAndDez.ui.screens.more

import android.os.Bundle
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.commons.extensions.startActivity
import com.deshAndDez.databinding.FragmentMoreBinding
import com.deshAndDez.ui.aboutApp.AboutUsActivity
import com.deshAndDez.ui.contactus.ContactUsActivity
import com.deshAndDez.ui.dialogs.LanguageSheetDialog

class MoreActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: FragmentMoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActivity()
    }


    //Entry point to this fragment
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
        binding.editAccountTextview.setOnClickListener { }
        binding.languageTextview.setOnClickListener {
            LanguageSheetDialog(this, "", onConfirmClicked = {}).show()
        }
        binding.contactUsTextview.setOnClickListener {
            startActivity(ContactUsActivity::class.java)
        }
        binding.aboutAppTextview.setOnClickListener {
            startActivity(AboutUsActivity::class.java)
        }
        binding.commonQuestionTextview.setOnClickListener { }
        binding.termsConditionsTextview.setOnClickListener { }
        binding.privacyPolicyTextview.setOnClickListener { }
        binding.rateAppTextview.setOnClickListener { }
        binding.deleteAccountTextview.setOnClickListener { }
    }
}
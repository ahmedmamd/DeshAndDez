package com.tmalty.ui.main.fragments.more

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.tmalty.R
import com.tmalty.base.BaseActivity
import com.tmalty.base.BaseFragment
import com.tmalty.databinding.ActivityMainBinding
import com.tmalty.databinding.FragmentMoreBinding

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
    }
}
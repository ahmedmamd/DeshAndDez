package com.tmalty.ui.main.activities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.tmalty.base.BaseActivity
import com.tmalty.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private val TAG = "MainActivity"

    //declare view and objects
    lateinit var binding: ActivityMainBinding
//    private val viewModel: MainViewModel by viewModels()

    override fun setUpLayoutView(savedInstanceState: Bundle?): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setupActivity()
        return binding.root
    }

    //Entry point to this activity
    private fun setupActivity() {
        setupLocationsCollector()
        setupUI()
        setupListeners()
    }

    private fun setupLocationsCollector() {
    }

    // Set up the UI components
    private fun setupUI() {
        // Set up any UI-related configurations here
    }

    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
    }
}
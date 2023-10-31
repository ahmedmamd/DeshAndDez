package com.tmalty.ui.auth.profile.fragments

import android.os.Bundle
import android.view.View
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.databinding.FragmentProfileStatisiticsBinding

class ProfileStatisticsFragment : BaseFragment(R.layout.fragment_profile_statisitics) {

    // Declare view and objects
    lateinit var binding: FragmentProfileStatisiticsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileStatisiticsBinding.bind(requireView())
        binding.lifecycleOwner = this
        setupFragment()
    }


    //Entry point to this fragment
    private fun setupFragment() {
        setupUI()
        setupListeners()
    }

    // Set up the UI components
    private fun setupUI() {
        // Set up any UI-related configurations here
    }



    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
    }


}
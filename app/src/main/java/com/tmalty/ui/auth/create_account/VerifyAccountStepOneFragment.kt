package com.tmalty.ui.auth.create_account

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.databinding.FragmentVerifyAccountStepOneBinding

class VerifyAccountStepOneFragment : BaseFragment(R.layout.fragment_verify_account_step_one) {

    // Declare view and objects
    lateinit var binding: FragmentVerifyAccountStepOneBinding

    //Departments

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVerifyAccountStepOneBinding.bind(requireView())
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
        binding.toolbar.back.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_confirmAccountStepOneFragment_to_confirmAccountStepTwoFragment)
        }
    }
}
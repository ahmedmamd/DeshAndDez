package com.tmalty.ui.auth.create_account

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.databinding.FragmentSignUpBinding
import com.tmalty.databinding.FragmentVerifyAccountStepFourBinding

class VerifyAccountStepFourFragment : BaseFragment(R.layout.fragment_verify_account_step_four) {

    // Declare view and objects
    lateinit var binding: FragmentVerifyAccountStepFourBinding

    //Departments

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVerifyAccountStepFourBinding.bind(requireView())
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
        binding.confirmAndFinishButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.confirmAndFinishButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }
}
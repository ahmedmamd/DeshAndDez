package com.tmalty.ui.auth.login

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    // Declare view and objects
    lateinit var binding: FragmentLoginBinding

    //Departments

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(requireView())
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
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

        }
        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
        binding.tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgetPasswordFragment)
        }
        binding.btnGoogle.setOnClickListener {}
    }
}
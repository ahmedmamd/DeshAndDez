package com.tmalty.ui.auth.profile.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.data.models.core.Department
import com.tmalty.data.models.core.SubDepartment
import com.tmalty.databinding.FragmentCustomerProfileBinding
import com.tmalty.databinding.FragmentDepartmentsBinding
import com.tmalty.databinding.FragmentProfileVerificationsBinding
import com.tmalty.ui.main.fragments.departments.adapters.DepartmentsAdapter
import com.tmalty.ui.main.fragments.departments.adapters.SubDepartmentsAdapter

class ProfileVerificationsFragment : BaseFragment(R.layout.fragment_profile_verifications) {

    // Declare view and objects
    lateinit var binding: FragmentProfileVerificationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileVerificationsBinding.bind(requireView())
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
package com.tmalty.ui.auth.profile.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.data.models.core.Department
import com.tmalty.data.models.core.Service
import com.tmalty.data.models.core.SubDepartment
import com.tmalty.databinding.FragmentCustomerProfileBinding
import com.tmalty.databinding.FragmentDepartmentsBinding
import com.tmalty.databinding.FragmentProfileServicesBinding
import com.tmalty.ui.main.fragments.departments.adapters.DepartmentsAdapter
import com.tmalty.ui.main.fragments.departments.adapters.SubDepartmentsAdapter
import com.tmalty.ui.main.fragments.search.adapters.SearchAdapter

class ProfileServicesFragment : BaseFragment(R.layout.fragment_profile_services) {

    // Declare view and objects
    lateinit var binding: FragmentProfileServicesBinding
    lateinit var searchAdapter: SearchAdapter
    private val servicesList: MutableList<Service> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupSearchAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileServicesBinding.bind(requireView())
        binding.lifecycleOwner = this
        setupFragment()
    }


    //Entry point to this fragment
    private fun setupFragment() {
        setupUI()
        setupListeners()
        setupSearchRecycler()
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
    }


    private fun setupSearchRecycler() {
        binding.recycler.apply {
            layoutManager = GridLayoutManager(requireActivity(),2)
            adapter = searchAdapter
        }
    }

    private fun setupSearchAdapter() {
        searchAdapter = SearchAdapter {

        }
        servicesList.add(Service())
        servicesList.add(Service())
        servicesList.add(Service())
        servicesList.add(Service())
        servicesList.add(Service())
        servicesList.add(Service())
        servicesList.add(Service())
        servicesList.add(Service())
        servicesList.add(Service())
        servicesList.add(Service())
        servicesList.add(Service())
        servicesList.add(Service())
        searchAdapter.setData(servicesList)
    }

}
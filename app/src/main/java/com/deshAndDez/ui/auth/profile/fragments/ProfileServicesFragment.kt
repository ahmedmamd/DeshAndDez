package com.deshAndDez.ui.auth.profile.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.commons.extensions.startActivity
import com.deshAndDez.data.models.core.Service
import com.deshAndDez.databinding.FragmentProfileServicesBinding
import com.deshAndDez.ui.screens.search.adapters.SearchAdapter
import com.deshAndDez.ui.screens.servicedetails.ServiceDetailsActivity

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
        binding.addServiceButton.setOnClickListener {
            startActivity(com.deshAndDez.ui.screens.addservice.AddServiceStepOneActivity::class.java)
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
            startActivity(ServiceDetailsActivity::class.java)
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
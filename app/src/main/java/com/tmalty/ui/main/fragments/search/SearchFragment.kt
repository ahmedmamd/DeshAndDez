package com.tmalty.ui.main.fragments.search

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.data.models.core.Purchase
import com.tmalty.data.models.core.Service
import com.tmalty.databinding.FragmentSearchBinding
import com.tmalty.ui.main.fragments.purchase.adapters.PurchaseAdapter
import com.tmalty.ui.main.fragments.search.adapters.SearchAdapter

class SearchFragment : BaseFragment(R.layout.fragment_search) {

    // Declare view and objects
    lateinit var binding: FragmentSearchBinding

    lateinit var searchAdapter: SearchAdapter
    private val servicesList: MutableList<Service> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupSearchAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(requireView())
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
        setupSearchRecycler()
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupSearchRecycler() {
        binding.purchasesRecycler.apply {
            layoutManager = GridLayoutManager(requireActivity(),2)
            adapter = searchAdapter
        }
    }

    private fun setupSearchAdapter() {
        searchAdapter = SearchAdapter {
            navigateToServiceDetails(it)
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

    private fun navigateToServiceDetails(it: Service) {
        findNavController().navigate(R.id.action_searchFragment_to_serviceDetailsFragment)
    }
}
package com.tmalty.ui.main.fragments.servicedetails

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.data.models.core.Reviews
import com.tmalty.data.models.core.ServiceUpgrade
import com.tmalty.databinding.FragmentServiceDetailsBinding
import com.tmalty.ui.dialogs.ReviewsSheetDialog
import com.tmalty.ui.dialogs.ShareServiceSheetDialog
import com.tmalty.ui.main.fragments.servicedetails.adapters.ServiceUpgradeAdapter

class ServiceDetailsFragment : BaseFragment(R.layout.fragment_service_details) {

    // Declare view and objects
    lateinit var binding: FragmentServiceDetailsBinding
    lateinit var serviceUpgradesAdapter: ServiceUpgradeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupServiceUpgradesAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentServiceDetailsBinding.bind(requireView())
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
        setupQuantityPicker()
    }

    private fun setupQuantityPicker() {
        binding.numberPicker.setupNumberPicker(1, 100) { newValue -> }
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.share.setOnClickListener {
            ShareServiceSheetDialog(requireActivity()).show()
        }
        binding.reviewsTextview.setOnClickListener {
            ReviewsSheetDialog(requireActivity(), listOf(Reviews(),Reviews(),Reviews(),Reviews(),Reviews(),Reviews())).show()
        }
    }

    private fun setupServiceUpgradesAdapter() {
        serviceUpgradesAdapter = ServiceUpgradeAdapter {
        }
        val serviceUpgradesList = mutableListOf<ServiceUpgrade>()
        serviceUpgradesList.add(ServiceUpgrade())
        serviceUpgradesList.add(ServiceUpgrade())
        serviceUpgradesList.add(ServiceUpgrade())
        serviceUpgradesAdapter.setData(serviceUpgradesList)
    }

    private fun setupSearchRecycler() {
        binding.serviceUpgradesRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = serviceUpgradesAdapter
        }
    }

}

package com.tmalty.ui.auth.profile.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.data.models.core.Department
import com.tmalty.data.models.core.Reviews
import com.tmalty.data.models.core.Service
import com.tmalty.data.models.core.SubDepartment
import com.tmalty.databinding.FragmentCustomerProfileBinding
import com.tmalty.databinding.FragmentDepartmentsBinding
import com.tmalty.databinding.FragmentProfileReviewsBinding
import com.tmalty.ui.main.fragments.departments.adapters.DepartmentsAdapter
import com.tmalty.ui.main.fragments.departments.adapters.SubDepartmentsAdapter
import com.tmalty.ui.main.fragments.servicedetails.adapters.ReviewsAdapter

class ProfileReviewsFragment : BaseFragment(R.layout.fragment_profile_reviews) {

    // Declare view and objects
    lateinit var binding: FragmentProfileReviewsBinding
    lateinit var reviewsAdapter: ReviewsAdapter
    private val list: MutableList<Reviews> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupOrderAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileReviewsBinding.bind(requireView())
        binding.lifecycleOwner = this
        setupFragment()
    }


    //Entry point to this fragment
    private fun setupFragment() {
        setupUI()
        setupListeners()
        setupOrderRecycler()
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
    private fun setupOrderRecycler() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = reviewsAdapter
        }
    }

    private fun setupOrderAdapter() {
        reviewsAdapter = ReviewsAdapter()
        list.add(Reviews())
        list.add(Reviews())
        list.add(Reviews())
        list.add(Reviews())
        list.add(Reviews())
        list.add(Reviews())
        reviewsAdapter.setData(list)
    }

}
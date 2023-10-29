package com.tmalty.ui.auth.profile

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.databinding.FragmentCustomerProfileBinding
import com.tmalty.databinding.FragmentDepartmentsBinding
import com.tmalty.ui.auth.profile.adapters.ProfilePagerAdapter
import com.tmalty.ui.auth.profile.fragments.ProfileBioFragment
import com.tmalty.ui.auth.profile.fragments.ProfileReviewsFragment
import com.tmalty.ui.auth.profile.fragments.ProfileServicesFragment
import com.tmalty.ui.auth.profile.fragments.ProfileStatisticsFragment
import com.tmalty.ui.auth.profile.fragments.ProfileVerificationsFragment
import com.tmalty.ui.main.fragments.departments.adapters.DepartmentsAdapter
import com.tmalty.ui.main.fragments.departments.adapters.SubDepartmentsAdapter

class CustomerProfileFragment : BaseFragment(R.layout.fragment_customer_profile) {

    // Declare view and objects
    lateinit var binding: FragmentCustomerProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCustomerProfileBinding.bind(requireView())
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
    }


    //Set up ViewPager
    private fun setupViewPager() {
        val fragmentList = listOf(
            ProfileBioFragment(),
            ProfileServicesFragment(),
            ProfileReviewsFragment(),
            ProfileVerificationsFragment(),
            ProfileStatisticsFragment()
        )
        val adapter = ProfilePagerAdapter(requireActivity(), fragmentList)
        binding.viewPager.adapter = adapter
        binding.viewPager.offscreenPageLimit = 2
        binding.viewPager.isUserInputEnabled = false
    }

    //Set up TabLayout
    private fun setupTabLayout() {
        val list = listOf<String>(
            getString(R.string.bio),
            getString(R.string.services),
            getString(R.string.reviews),
            getString(R.string.verifications),
            getString(R.string.statisitics)
        )
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = list[position]
        }.attach()
        // Make the first tab indicator visible initially
        binding.tabLayout.getTabAt(0)!!
    }

    //Set up tabLayout selection listener
    private fun setupTabLayoutSelectionsListener() {
        // Handle tab selection
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // Customize UI for selected tab
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // Customize UI for unselected tab
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Handle tab reselection if needed
            }
        })
    }


}
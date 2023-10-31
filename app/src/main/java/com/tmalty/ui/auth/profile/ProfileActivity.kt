package com.tmalty.ui.auth.profile

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tmalty.R
import com.tmalty.base.BaseActivity
import com.tmalty.commons.extensions.startActivity
import com.tmalty.databinding.ActivityCustomerProfileBinding
import com.tmalty.ui.auth.profile.adapters.ProfilePagerAdapter
import com.tmalty.ui.auth.profile.fragments.*

class ProfileActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: ActivityCustomerProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActivity()
    }

    //Entry point to this activity
    private fun setupActivity() {
        setupUI()
        setupListeners()
    }

    // Set up the UI components
    private fun setupUI() {
        // Set up any UI-related configurations here
        binding.toolbar.editImageview.visibility = View.VISIBLE
        setupViewPager()
        setupTabLayout()
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.back.setOnClickListener {
            finish()
        }
        binding.toolbar.editImageview.setOnClickListener {
            startActivity(EditProfileActivity::class.java)
        }
        setupTabLayoutSelectionsListener()
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
        val adapter = ProfilePagerAdapter(this, fragmentList)
        binding.viewPager.adapter = adapter
        binding.viewPager.offscreenPageLimit = 5
        binding.viewPager.isUserInputEnabled = false
    }

    //Set up TabLayout
    private fun setupTabLayout() {
        val tabsTitlesList = listOf<String>(
            getString(R.string.bio),
            getString(R.string.services),
            getString(R.string.reviews),
            getString(R.string.verifications),
            getString(R.string.statisitics)
        )
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.setCustomView(R.layout.custom_tab_item)
            val titleTextView = tab.customView?.findViewById<TextView>(R.id.title_textview)
            titleTextView?.text = tabsTitlesList[position]
        }.attach()
        // Make the first tab indicator visible initially
        binding.tabLayout.getTabAt(0)?.let { tab ->
            setUpTabSelected(tab)
        }
    }

    //Set up tabLayout selection listener
    private fun setupTabLayoutSelectionsListener() {
        // Handle tab selection
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // Customize UI for selected tab
                setUpTabSelected(tab)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // Customize UI for unselected tab
                setUpTabUnSelected(tab)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Handle tab reselection if needed
            }
        })
    }


    // Set up tab selected
    private fun setUpTabSelected(tab: TabLayout.Tab) {
        // Access custom view elements
        val indicatorView = tab.customView?.findViewById<View>(R.id.indicator_view)
        // Customize indicator and title
        // For example, set indicator color for the active tab
        indicatorView?.visibility = View.VISIBLE
    }

    // Set up tab un selected
    private fun setUpTabUnSelected(tab: TabLayout.Tab) {
        // Access custom view elements
        val indicatorView = tab.customView?.findViewById<View>(R.id.indicator_view)
        // Customize indicator and title
        // For example, set indicator color for the active tab
        indicatorView?.visibility = View.GONE
    }
}
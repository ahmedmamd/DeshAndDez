package com.tmalty.ui.main.fragments.servicedetails

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.base.BaseActivity
import com.tmalty.data.models.core.Reviews
import com.tmalty.data.models.core.ServiceUpgrade
import com.tmalty.databinding.ActivityServiceDetailsBinding
import com.tmalty.ui.dialogs.ReviewsSheetDialog
import com.tmalty.ui.dialogs.ShareServiceSheetDialog
import com.tmalty.ui.main.fragments.servicedetails.adapters.ServiceUpgradeAdapter

class ServiceDetailsActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: ActivityServiceDetailsBinding
    lateinit var serviceUpgradesAdapter: ServiceUpgradeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActivity()
    }

    //Entry point to this activity
    private fun setupActivity() {
        setupServiceUpgradesAdapter()
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
            finish()
        }
        binding.share.setOnClickListener {
            ShareServiceSheetDialog(this).show()
        }
        binding.reviewsTextview.setOnClickListener {
            ReviewsSheetDialog(this, listOf(
                Reviews(),
                Reviews(),
                Reviews(),
                Reviews(),
                Reviews(),
                Reviews()
            )).show()
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
            layoutManager = LinearLayoutManager(this@ServiceDetailsActivity)
            adapter = serviceUpgradesAdapter
        }
    }
}
package com.deshAndDez.ui.screens.search

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.commons.extensions.startActivity
import com.deshAndDez.data.models.core.Service
import com.deshAndDez.databinding.ActivitySearchBinding
import com.deshAndDez.ui.dialogs.ServiceFilterSheetDialog
import com.deshAndDez.ui.screens.search.adapters.SearchAdapter
import com.deshAndDez.ui.screens.servicedetails.ServiceDetailsActivity
import com.deshAndDez.ui.screens.servicedetails.adapters.ServiceUpgradeAdapter

class SearchActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: ActivitySearchBinding
    lateinit var serviceUpgradesAdapter: ServiceUpgradeAdapter

    lateinit var searchAdapter: SearchAdapter
    private val servicesList: MutableList<Service> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
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
        binding.toolbar.filterImageview.visibility = View.VISIBLE
        setupSearchAdapter()
        setupSearchRecycler()
    }



    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.back.setOnClickListener {
            finish()
        }
        binding.toolbar.filterImageview.setOnClickListener {
            ServiceFilterSheetDialog(this).show()
        }
    }

    private fun setupSearchRecycler() {
        binding.purchasesRecycler.apply {
            layoutManager = GridLayoutManager(this@SearchActivity, 2)
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
        startActivity(ServiceDetailsActivity::class.java)
    }
}
package com.deshAndDez.ui.screens.purchase

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.R
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.base.SelectionModel
import com.deshAndDez.commons.extensions.startActivity
import com.deshAndDez.data.models.core.Purchase
import com.deshAndDez.databinding.ActivityPurchaseBinding
import com.deshAndDez.ui.dialogs.CheckboxSelectionSheetDialog
import com.deshAndDez.ui.screens.purchase.adapters.PurchaseAdapter

class PurchasesActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: ActivityPurchaseBinding

    //Departments
    lateinit var purchasesAdapter: PurchaseAdapter
    private val purchaseList: MutableList<Purchase> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPurchaseBinding.inflate(layoutInflater)
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
        setupPurchaseAdapter()
        binding.toolbar.filterImageview.visibility = View.VISIBLE
        setupPurchaseRecycler()
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.back.setOnClickListener {
            finish()
        }
        binding.toolbar.filterImageview.setOnClickListener {
            CheckboxSelectionSheetDialog(this,getString(R.string.order_status),
                listOf(
                    SelectionModel("1", getString(R.string.requested)),
                    SelectionModel("2", getString(R.string.running)),
                    SelectionModel("3", getString(R.string.canceled))
                ),
                onItemSelected = {
                },
                onItemRemoved = {
                }).show()
        }
    }

    private fun setupPurchaseRecycler() {
        binding.purchasesRecycler.apply {
            layoutManager = LinearLayoutManager(this@PurchasesActivity)
            adapter = purchasesAdapter
        }
    }

    private fun setupPurchaseAdapter() {
        purchasesAdapter = PurchaseAdapter {
            startActivity(PurchasesDetailsActivity::class.java)
        }
        purchaseList.add(Purchase())
        purchaseList.add(Purchase())
        purchaseList.add(Purchase())
        purchaseList.add(Purchase())
        purchaseList.add(Purchase())
        purchaseList.add(Purchase())
        purchaseList.add(Purchase())
        purchaseList.add(Purchase())
        purchasesAdapter.setData(purchaseList)
    }
}
package com.tmalty.ui.main.fragments.orders

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseActivity
import com.tmalty.base.SelectionModel
import com.tmalty.commons.extensions.startActivity
import com.tmalty.data.models.core.Order
import com.tmalty.data.models.core.OrderStatus
import com.tmalty.databinding.ActivityOrdersBinding
import com.tmalty.ui.dialogs.CheckboxSelectionSheetDialog
import com.tmalty.ui.main.fragments.orders.adapters.OrdersAdapter

class OrdersActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: ActivityOrdersBinding

    //Departments
    lateinit var ordersAdapter: OrdersAdapter
    private val ordersList: MutableList<Order> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrdersBinding.inflate(layoutInflater)
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
        setupOrderAdapter()
        binding.toolbar.filterImageview.visibility = View.VISIBLE
        setupOrderRecycler()
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

    private fun setupOrderRecycler() {
        binding.ordersRecycler.apply {
            layoutManager = LinearLayoutManager(this@OrdersActivity)
            adapter = ordersAdapter
        }
    }

    private fun setupOrderAdapter() {
        ordersAdapter = OrdersAdapter {
            startActivity(OrderDetailsActivity::class.java)
        }
        ordersList.add(Order())
        ordersList.add(Order())
        ordersList.add(Order())
        ordersList.add(Order())
        ordersList.add(Order())
        ordersList.add(Order())
        ordersList.add(Order())
        ordersAdapter.setData(ordersList)
    }
}
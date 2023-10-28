package com.tmalty.ui.dialogs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tmalty.R
import com.tmalty.commons.extensions.setUpSheetUi
import com.tmalty.data.models.core.OrderStatus
import com.tmalty.databinding.SheetLayoutCheckboxSelectionBinding
import com.tmalty.ui.main.fragments.orders.adapters.OrdersStatusAdapter
class SearchSheetDialog(
    private val screenContext: Context,
    private val list: List<OrderStatus>,
    private val onItemSelected: (String) -> Unit,
    private val onItemRemoved: (String) -> Unit
) :
    BottomSheetDialog(screenContext, R.style.BottomSheetDialog) {
    var binding: SheetLayoutCheckboxSelectionBinding =
        SheetLayoutCheckboxSelectionBinding.inflate(LayoutInflater.from(screenContext))
    private var lang = ""

    //Departments
    lateinit var ordersStatusAdapter: OrdersStatusAdapter

    init {
        setupBottomSheet()
    }

    //Entry point to this bottom sheet dialog
    private fun setupBottomSheet() {
        setupUI()
        setupListeners()
    }

    // Set up the UI components
    private fun setupUI() {
        // Set up any UI-related configurations here
        setContentView(binding.root)
        setUpSheetUi(binding.root.parent)
        setupOrderAdapter()
        setupOrderRecycler()
    }

    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.closeImageview.setOnClickListener {
            dismiss()
        }
    }

    private fun setupOrderRecycler() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(screenContext)
            adapter = ordersStatusAdapter
        }
    }

    private fun setupOrderAdapter() {
        ordersStatusAdapter = OrdersStatusAdapter(onItemClicked = { orderStatus, isChecked ->
            if (isChecked) {
                onItemSelected(orderStatus.id!!)
            } else onItemRemoved(orderStatus.id!!)
            dismiss()
        })
        ordersStatusAdapter.setData(list)
    }

    private fun handleContinueButtonClickAction(view: View) {
        dismiss()
    }
}
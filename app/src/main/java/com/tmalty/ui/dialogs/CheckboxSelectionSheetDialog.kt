package com.tmalty.ui.dialogs

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tmalty.R
import com.tmalty.base.SelectionModel
import com.tmalty.commons.extensions.setUpSheetUi
import com.tmalty.data.models.core.OrderStatus
import com.tmalty.databinding.SheetLayoutCheckboxSelectionBinding
import com.tmalty.ui.main.fragments.orders.adapters.CheckboxSelectionAdapter

class CheckboxSelectionSheetDialog(
    private val screenContext: Context,
    private val sheetTitle: String,
    private val list: List<SelectionModel>,
    private val onItemSelected: (String) -> Unit,
    private val onItemRemoved: (String) -> Unit
) :
    BottomSheetDialog(screenContext, R.style.BottomSheetDialog) {
    var binding: SheetLayoutCheckboxSelectionBinding =
        SheetLayoutCheckboxSelectionBinding.inflate(LayoutInflater.from(screenContext))
    private var lang = ""

    //Departments
    lateinit var selectionAdapter: CheckboxSelectionAdapter

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
        binding.sheetTitleTextview.text = sheetTitle
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
            adapter = selectionAdapter
        }
    }

    private fun setupOrderAdapter() {
        selectionAdapter = CheckboxSelectionAdapter(onItemClicked = { item, isChecked ->
            if (isChecked) {
                onItemSelected(item.id!!)
            } else onItemRemoved(item.id!!)
            dismiss()
        })
        selectionAdapter.setData(list)
    }
}
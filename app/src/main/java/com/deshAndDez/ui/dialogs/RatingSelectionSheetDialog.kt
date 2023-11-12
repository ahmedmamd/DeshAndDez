package com.deshAndDez.ui.dialogs

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.deshAndDez.R
import com.deshAndDez.base.RatingModel
import com.deshAndDez.commons.extensions.setUpSheetUi
import com.deshAndDez.databinding.SheetLayoutReviewSelectionBinding
import com.deshAndDez.ui.screens.orders.adapters.ReviewSelectionAdapter

class RatingSelectionSheetDialog(
    private val screenContext: Context,
    private val sheetTitle: String,
    private val list: List<RatingModel>,
    private val onItemSelected: (String) -> Unit
) :
    BottomSheetDialog(screenContext, R.style.BottomSheetDialog) {
    var binding: SheetLayoutReviewSelectionBinding =
        SheetLayoutReviewSelectionBinding.inflate(LayoutInflater.from(screenContext))

    //Departments
    lateinit var selectionAdapter: ReviewSelectionAdapter

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
        selectionAdapter = ReviewSelectionAdapter(onItemClicked = { item, isChecked ->
            if (isChecked) {
                onItemSelected(item.id!!)
            }
            dismiss()
        })
        selectionAdapter.setData(list)
    }
}
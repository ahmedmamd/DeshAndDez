package com.tmalty.ui.dialogs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tmalty.R
import com.tmalty.commons.extensions.setUpSheetUi
import com.tmalty.data.models.core.Reviews
import com.tmalty.databinding.SheetLayoutCheckboxSelectionBinding
import com.tmalty.databinding.SheetLayoutReviewsBinding
import com.tmalty.ui.main.fragments.orders.adapters.OrdersStatusAdapter
import com.tmalty.ui.main.fragments.servicedetails.adapters.ReviewsAdapter

class ReviewsSheetDialog(
    private val screenContext: Context,
    private val list: List<Reviews>,
) :
    BottomSheetDialog(screenContext, R.style.BottomSheetDialog) {
    var binding: SheetLayoutReviewsBinding =
        SheetLayoutReviewsBinding.inflate(LayoutInflater.from(screenContext))
    //Departments
    lateinit var reviewsAdapter: ReviewsAdapter

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
            adapter = reviewsAdapter
        }
    }

    private fun setupOrderAdapter() {
        reviewsAdapter = ReviewsAdapter()
        reviewsAdapter.setData(list)
    }
}
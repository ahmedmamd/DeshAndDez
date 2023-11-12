package com.deshAndDez.ui.dialogs

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.deshAndDez.R
import com.deshAndDez.commons.extensions.setUpSheetUi
import com.deshAndDez.data.models.core.Reviews
import com.deshAndDez.databinding.SheetLayoutReviewsBinding
import com.deshAndDez.ui.screens.servicedetails.adapters.ReviewsAdapter

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
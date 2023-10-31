package com.tmalty.ui.dialogs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tmalty.R
import com.tmalty.base.RatingModel
import com.tmalty.base.SelectionModel
import com.tmalty.commons.extensions.setUpSheetUi
import com.tmalty.data.models.core.OrderStatus
import com.tmalty.databinding.SheetLayoutCheckboxSelectionBinding
import com.tmalty.databinding.SheetLayoutFilterBinding
import com.tmalty.ui.main.fragments.orders.adapters.CheckboxSelectionAdapter

class ServiceFilterSheetDialog(
    private val screenContext: Context,
) :
    BottomSheetDialog(screenContext, R.style.BottomSheetDialog) {
    var binding: SheetLayoutFilterBinding =
        SheetLayoutFilterBinding.inflate(LayoutInflater.from(screenContext))

    //Departments

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
    }

    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.closeImageview.setOnClickListener {
            dismiss()
        }

        binding.nextButton.setOnClickListener {
            dismiss()
        }
        binding.previousButton.setOnClickListener {
            dismiss()
        }
        binding.serviceReviewTextview.setOnClickListener {
            openRatingDialog()
        }
        binding.departmentConstraint.setOnClickListener {

        }
        binding.sellerLevelConstraint.setOnClickListener {
            openSellerLevelDialog()
        }
        binding.sellerStatusConstraint.setOnClickListener {
            openSellerStatusDialog()
        }
    }

    private fun openSellerLevelDialog() {
        CheckboxSelectionSheetDialog(screenContext, screenContext.getString(R.string.seller_level),
            listOf(
                SelectionModel("1", screenContext.getString(R.string.distinguished_seller)),
                SelectionModel("2", screenContext.getString(R.string.active_seller)),
                SelectionModel("3", screenContext.getString(R.string.new_seller))
            ),
            onItemSelected = {
                dismiss()
            },
            onItemRemoved = {
                dismiss()
            }).show()
    }


    private fun openSellerStatusDialog() {
        CheckboxSelectionSheetDialog(screenContext, screenContext.getString(R.string.seller_status),
            listOf(
                SelectionModel("1", screenContext.getString(R.string.verified_id)),
                SelectionModel("2", screenContext.getString(R.string.online_now)),
            ),
            onItemSelected = {
                             dismiss()
            },
            onItemRemoved = {
                dismiss()
            }).show()
    }

    private fun openRatingDialog() {
        RatingSelectionSheetDialog(
            screenContext, screenContext.getString(R.string.service_review),
            listOf(
                RatingModel("1", 5),
                RatingModel("2", 4),
                RatingModel("3", 3),
                RatingModel("4", 2),
                RatingModel("5", 1),
            ),
            onItemSelected = {
                dismiss()
            },
        ).show()
    }

}
package com.deshAndDez.ui.dialogs

import android.content.Context
import android.view.LayoutInflater
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.deshAndDez.R
import com.deshAndDez.commons.extensions.setUpSheetUi
import com.deshAndDez.databinding.SheetLayoutAlertBinding

class AlertSheetDialog(
    private val screenContext: Context,
    private val title: String,
    private val description: String,
) :
    BottomSheetDialog(screenContext, R.style.BottomSheetDialog) {
    var binding: SheetLayoutAlertBinding =
        SheetLayoutAlertBinding.inflate(LayoutInflater.from(screenContext))

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
        binding.titleTextview.text = title
        binding.descriptionTextview.text = description
    }

    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.closeImageview.setOnClickListener {
            dismiss()
        }
    }
}
package com.deshAndDez.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import com.deshAndDez.R
import com.deshAndDez.commons.extensions.setUpSheetUi
import com.deshAndDez.databinding.DialogLayoutReportConfirmationBinding

class ReportConfirmationDialog(private val screenContext: Context, val onYesClick:()->Unit) :
    Dialog(screenContext) {
    var binding: DialogLayoutReportConfirmationBinding =
        DialogLayoutReportConfirmationBinding.inflate(LayoutInflater.from(screenContext))

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
        setUpSheetUi(WindowManager.LayoutParams.MATCH_PARENT)
        setCancelable(true)
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.yesButton.setOnClickListener { view ->
            handleYesButtonClickAction(view)
        }
        binding.noButton.setOnClickListener { view ->
            handleNoButtonClickAction(view)
        }
        binding.container.setOnClickListener { view ->
         dismiss()
        }
    }

    private fun handleYesButtonClickAction(view: View) {
        onYesClick()
        dismiss()
    }

    private fun handleNoButtonClickAction(view: View) {
        dismiss()
    }

}
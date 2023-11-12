package com.deshAndDez.ui.dialogs

import android.content.Context
import android.view.LayoutInflater
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.deshAndDez.R
import com.deshAndDez.commons.extensions.setUpSheetUi
import com.deshAndDez.databinding.SheetLayoutLanguageBinding

class LanguageSheetDialog(
    private val screenContext: Context,
    private val selectedLanguage: String,
    var onConfirmClicked: () -> Unit,
) :
    BottomSheetDialog(screenContext, R.style.BottomSheetDialog) {
    var binding: SheetLayoutLanguageBinding =
        SheetLayoutLanguageBinding.inflate(LayoutInflater.from(screenContext))

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
        binding.radioArabic.setOnCheckedChangeListener { compoundButton, isChecked ->

        }
        binding.radioEnglish.setOnCheckedChangeListener { compoundButton, isChecked ->

        }
        binding.closeImageview.setOnClickListener {
            dismiss()
        }
        binding.confirmButton.setOnClickListener {
            onConfirmClicked()
            dismiss()
        }
    }
}
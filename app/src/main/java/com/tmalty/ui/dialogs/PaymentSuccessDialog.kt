package com.tmalty.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.tmalty.R
import com.tmalty.databinding.DialogLayoutPaymentSuccessBinding

class PaymentSuccessDialog(
    context: Context,
    var onPurchaseClicked: () -> Unit,
    var onHomeClicked: () -> Unit
) :
    Dialog(context, R.style.BottomSheetDialog) {
    var binding: DialogLayoutPaymentSuccessBinding =
        DialogLayoutPaymentSuccessBinding.inflate(LayoutInflater.from(context))


    init {
        setupDialog()
    }

    //Entry point to this bottom sheet dialog
    private fun setupDialog() {
        setupUI()
        setupListeners()
    }

    // Set up the UI components
    private fun setupUI() {
        // Set up any UI-related configurations here
        setContentView(binding.root)
        setCancelable(false)
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.purchasesTextview.setOnClickListener {
            onPurchaseClicked()
            dismiss()
        }
        binding.homeTextview.setOnClickListener {
            onHomeClicked()
            dismiss()
        }
    }

}
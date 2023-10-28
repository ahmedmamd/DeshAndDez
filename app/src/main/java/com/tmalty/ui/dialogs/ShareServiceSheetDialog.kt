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
import com.tmalty.databinding.SheetLayoutShareServiceBinding
import com.tmalty.ui.main.fragments.orders.adapters.OrdersStatusAdapter

class ShareServiceSheetDialog(
    private val screenContext: Context
) :
    BottomSheetDialog(screenContext, R.style.BottomSheetDialog) {
    var binding: SheetLayoutShareServiceBinding =
        SheetLayoutShareServiceBinding.inflate(LayoutInflater.from(screenContext))
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
    }

    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.closeImageview.setOnClickListener {
            dismiss()
        }
        binding.facebookLinearlayout.setOnClickListener {
            dismiss()
        }
        binding.instagramLinearlayout.setOnClickListener {
            dismiss()
        }
        binding.twitterLinearlayout.setOnClickListener {
            dismiss()
        }
        binding.snapchatLinearlayout.setOnClickListener {
            dismiss()
        }
        binding.shareMoreLinearlayout.setOnClickListener {
            dismiss()
        }
        binding.copyLinkTextview.setOnClickListener {
            dismiss()
        }
    }
}
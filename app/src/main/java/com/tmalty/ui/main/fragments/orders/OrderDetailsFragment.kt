package com.tmalty.ui.main.fragments.orders

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.base.SelectionModel
import com.tmalty.data.models.core.Order
import com.tmalty.data.models.core.OrderStatus
import com.tmalty.databinding.FragmentOrderDetailsBinding
import com.tmalty.databinding.FragmentOrdersBinding
import com.tmalty.ui.dialogs.OrderStatusFilterSheetDialog
import com.tmalty.ui.main.fragments.orders.adapters.OrdersAdapter

class OrderDetailsFragment : BaseFragment(R.layout.fragment_order_details) {

    // Declare view and objects
    lateinit var binding: FragmentOrderDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrderDetailsBinding.bind(requireView())
        binding.lifecycleOwner = this
        setupFragment()
    }


    //Entry point to this fragment
    private fun setupFragment() {
        setupUI()
        setupListeners()
    }

    // Set up the UI components
    private fun setupUI() {
        // Set up any UI-related configurations here
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}
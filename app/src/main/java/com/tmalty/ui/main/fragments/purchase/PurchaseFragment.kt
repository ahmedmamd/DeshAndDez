package com.tmalty.ui.main.fragments.purchase

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.data.models.core.OrderStatus
import com.tmalty.data.models.core.Purchase
import com.tmalty.databinding.FragmentPurchaseBinding
import com.tmalty.ui.dialogs.OrderStatusFilterSheetDialog
import com.tmalty.ui.main.fragments.purchase.adapters.PurchaseAdapter

class PurchaseFragment : BaseFragment(R.layout.fragment_purchase) {

    // Declare view and objects
    lateinit var binding: FragmentPurchaseBinding

    //Departments
    lateinit var purchasesAdapter: PurchaseAdapter
    private val purchaseList: MutableList<Purchase> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupPurchaseAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPurchaseBinding.bind(requireView())
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
        binding.toolbar.filterImageview.visibility = View.VISIBLE
        setupPurchaseRecycler()
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.back.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.toolbar.filterImageview.setOnClickListener {
            OrderStatusFilterSheetDialog(requireActivity(),
                listOf<OrderStatus>(
                    OrderStatus("0", getString(R.string.requested)),
                    OrderStatus("1", getString(R.string.running)),
                    OrderStatus("0", getString(R.string.canceled))
                ),
                onItemSelected = {
                },
                onItemRemoved = {
                }).show()
        }
    }

    private fun setupPurchaseRecycler() {
        binding.purchasesRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = purchasesAdapter
        }
    }

    private fun setupPurchaseAdapter() {
        purchasesAdapter = PurchaseAdapter {
            findNavController().navigate(R.id.action_purchaseFragment_to_purchaseDetailsFragment)
        }
        purchaseList.add(Purchase())
        purchaseList.add(Purchase())
        purchaseList.add(Purchase())
        purchaseList.add(Purchase())
        purchaseList.add(Purchase())
        purchaseList.add(Purchase())
        purchaseList.add(Purchase())
        purchaseList.add(Purchase())
        purchasesAdapter.setData(purchaseList)
    }
}
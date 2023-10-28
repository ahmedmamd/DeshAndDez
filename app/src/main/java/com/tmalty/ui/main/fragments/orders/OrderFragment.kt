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
import com.tmalty.databinding.FragmentOrdersBinding
import com.tmalty.ui.dialogs.OrderStatusFilterSheetDialog
import com.tmalty.ui.main.fragments.orders.adapters.OrdersAdapter

class OrderFragment : BaseFragment(R.layout.fragment_orders) {

    // Declare view and objects
    lateinit var binding: FragmentOrdersBinding

    //Departments
    lateinit var ordersAdapter: OrdersAdapter
    private val ordersList: MutableList<Order> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupOrderAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrdersBinding.bind(requireView())
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
        setupOrderRecycler()
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

    private fun setupOrderRecycler() {
        binding.ordersRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = ordersAdapter
        }
    }

    private fun setupOrderAdapter() {
        ordersAdapter = OrdersAdapter {
            findNavController().navigate(R.id.action_orderFragment_to_orderDetailsFragment)
        }
        ordersList.add(Order())
        ordersList.add(Order())
        ordersList.add(Order())
        ordersList.add(Order())
        ordersList.add(Order())
        ordersList.add(Order())
        ordersList.add(Order())
        ordersAdapter.setData(ordersList)
    }
}
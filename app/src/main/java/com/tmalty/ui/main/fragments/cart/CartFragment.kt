package com.tmalty.ui.main.fragments.cart

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.data.models.core.Cart
import com.tmalty.data.models.core.Order
import com.tmalty.data.models.core.OrderStatus
import com.tmalty.databinding.FragmentCartBinding
import com.tmalty.ui.dialogs.OrderStatusFilterSheetDialog
import com.tmalty.ui.main.fragments.cart.adapters.CartAdapter
import com.tmalty.ui.main.fragments.orders.adapters.OrdersAdapter

class CartFragment : BaseFragment(R.layout.fragment_cart) {

    // Declare view and objects
    lateinit var binding: FragmentCartBinding

    //Departments
    lateinit var cartAdapter: CartAdapter
    private val cartList: MutableList<Cart> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupCartAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCartBinding.bind(requireView())
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
        setupCartRecycler()
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.back.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.orderNowTextview.setOnClickListener {
            findNavController().navigate(R.id.action_cartFragment_to_paymentFragment)
        }
    }

    private fun setupCartRecycler() {
        binding.ordersRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = cartAdapter
        }
    }

    private fun setupCartAdapter() {
        cartAdapter = CartAdapter {
        }
        cartList.add(Cart())
        cartList.add(Cart())
        cartList.add(Cart())
        cartList.add(Cart())
        cartList.add(Cart())
        cartList.add(Cart())
        cartAdapter.setData(cartList)
    }
}
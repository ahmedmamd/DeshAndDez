package com.deshAndDez.ui.screens.cart

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.commons.extensions.startActivity
import com.deshAndDez.data.models.core.Cart
import com.deshAndDez.databinding.FragmentCartBinding
import com.deshAndDez.ui.screens.cart.adapters.CartAdapter
import com.deshAndDez.ui.screens.payment.PaymentActivity

class CartActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: FragmentCartBinding

    //Departments
    lateinit var cartAdapter: CartAdapter
    private val cartList: MutableList<Cart> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActivity()
    }
    //Entry point to this fragment
    private fun setupActivity() {
        setupUI()
        setupListeners()
    }

    // Set up the UI components
    private fun setupUI() {
        // Set up any UI-related configurations here
        setupCartAdapter()
        setupCartRecycler()
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.back.setOnClickListener {
            finish()
        }
        binding.orderNowTextview.setOnClickListener {
            startActivity(PaymentActivity::class.java)
        }
    }

    private fun setupCartRecycler() {
        binding.ordersRecycler.apply {
            layoutManager = LinearLayoutManager(this@CartActivity)
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
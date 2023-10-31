package com.tmalty.ui.main.fragments.cart

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseActivity
import com.tmalty.base.BaseFragment
import com.tmalty.commons.extensions.startActivity
import com.tmalty.data.models.core.Cart
import com.tmalty.databinding.FragmentCartBinding
import com.tmalty.databinding.FragmentMoreBinding
import com.tmalty.ui.main.fragments.cart.adapters.CartAdapter
import com.tmalty.ui.main.fragments.payment.PaymentActivity

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
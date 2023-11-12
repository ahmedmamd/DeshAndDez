package com.deshAndDez.ui.screens.payment

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.R
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.commons.extensions.startActivity
import com.deshAndDez.data.models.core.Product
import com.deshAndDez.databinding.FragmentPaymentBinding
import com.deshAndDez.ui.dialogs.PaymentSuccessDialog
import com.deshAndDez.ui.main.activities.MainActivity
import com.deshAndDez.ui.screens.payment.adapters.ProductAdapter

class PaymentActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: FragmentPaymentBinding

    //Departments
    lateinit var productAdapter: ProductAdapter
    private val productList: MutableList<Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPaymentBinding.inflate(layoutInflater)
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

        binding.visaLinearlayout.setOnClickListener {
            binding.visaLinearlayout.setBackgroundResource(R.drawable.department_item_selected_background)
            binding.paypalLinearlayout.setBackgroundResource(R.drawable.department_item_background)
        }
        binding.paypalLinearlayout.setOnClickListener {
            binding.paypalLinearlayout.setBackgroundResource(R.drawable.department_item_selected_background)
            binding.visaLinearlayout.setBackgroundResource(R.drawable.department_item_background)
        }
        binding.confirmAndPayButton.setOnClickListener {
            PaymentSuccessDialog(this,
                onPurchaseClicked = {
                }, onHomeClicked = {
                    startActivity(MainActivity::class.java)
                    finishAffinity()
                }).show()
        }
    }

    private fun setupCartRecycler() {
        binding.productsRecycler.apply {
            layoutManager = LinearLayoutManager(this@PaymentActivity)
            adapter = productAdapter
        }
    }

    private fun setupCartAdapter() {
        productAdapter = ProductAdapter()
        productList.add(Product())
        productList.add(Product())
        productList.add(Product())
        productAdapter.setData(productList)
    }
}
package com.tmalty.ui.main.fragments.payment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseActivity
import com.tmalty.base.BaseFragment
import com.tmalty.commons.extensions.startActivity
import com.tmalty.data.models.core.Product
import com.tmalty.databinding.FragmentCartBinding
import com.tmalty.databinding.FragmentPaymentBinding
import com.tmalty.ui.dialogs.PaymentSuccessDialog
import com.tmalty.ui.main.activities.MainActivity
import com.tmalty.ui.main.fragments.payment.adapters.ProductAdapter

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
package com.tmalty.ui.main.fragments.payment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.data.models.core.Cart
import com.tmalty.data.models.core.Product
import com.tmalty.databinding.FragmentPaymentBinding
import com.tmalty.ui.dialogs.PaymentSuccessDialog
import com.tmalty.ui.main.fragments.cart.adapters.CartAdapter
import com.tmalty.ui.main.fragments.payment.adapters.ProductAdapter

class PaymentFragment : BaseFragment(R.layout.fragment_payment) {

    // Declare view and objects
    lateinit var binding: FragmentPaymentBinding

    //Departments
    lateinit var productAdapter: ProductAdapter
    private val productList: MutableList<Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupCartAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPaymentBinding.bind(requireView())
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

        binding.visaLinearlayout.setOnClickListener {
            binding.visaLinearlayout.setBackgroundResource(R.drawable.department_item_selected_background)
            binding.paypalLinearlayout.setBackgroundResource(R.drawable.department_item_background)
        }
        binding.paypalLinearlayout.setOnClickListener {
            binding.paypalLinearlayout.setBackgroundResource(R.drawable.department_item_selected_background)
            binding.visaLinearlayout.setBackgroundResource(R.drawable.department_item_background)
        }
        binding.confirmAndPayButton.setOnClickListener {
            PaymentSuccessDialog(requireActivity(),
                onPurchaseClicked = {
//                    findNavController().navigate(R.id.action_paymentFragment_to_purchaseFragment)
                }, onHomeClicked = {
                    findNavController().navigate(R.id.action_paymentFragment_to_homeFragment)
                }).show()
        }
    }

    private fun setupCartRecycler() {
        binding.productsRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
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
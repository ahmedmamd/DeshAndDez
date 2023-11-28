package com.deshAndDez.ui.screens.interest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.databinding.FragmentInterestsBinding
import com.deshAndDez.databinding.FragmentLanguageBinding
import com.deshAndDez.databinding.FragmentPaymentBinding
import com.deshAndDez.databinding.FragmentViewsBinding
import com.deshAndDez.ui.adapters.*

class PaymentFragment : BaseFragment(R.layout.fragment_payment) {

    // Declare view and objects
    lateinit var binding: FragmentPaymentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPaymentBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaymentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupListeners()
    }


    // Set up the UI components
    private fun setupUI() {
        // Set up any UI-related configurations here
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.backImageview.setOnClickListener {
            parentFragmentManager.popBackStack()
//            findNavController().popBackStack()
        }
    }

}
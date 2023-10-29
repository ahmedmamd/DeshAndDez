package com.tmalty.ui.main.fragments.more

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.data.models.core.Purchase
import com.tmalty.data.models.core.Service
import com.tmalty.databinding.FragmentMoreBinding
import com.tmalty.databinding.FragmentSearchBinding
import com.tmalty.ui.main.fragments.purchase.adapters.PurchaseAdapter
import com.tmalty.ui.main.fragments.search.adapters.SearchAdapter

class MoreFragment : BaseFragment(R.layout.fragment_more) {

    // Declare view and objects
    lateinit var binding: FragmentMoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMoreBinding.bind(requireView())
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
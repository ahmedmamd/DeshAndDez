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
import com.deshAndDez.databinding.FragmentViewsBinding
import com.deshAndDez.ui.adapters.*

class InterrestsFragment : BaseFragment(R.layout.fragment_interests) {

    // Declare view and objects
    lateinit var binding: FragmentInterestsBinding

    //Departments
    lateinit var interestAdapter: InterestAdapter
    private val interestsList: MutableList<Interest> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentInterestsBinding.inflate(layoutInflater)
        setupRecyclerAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInterestsBinding.inflate(layoutInflater, container, false)
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
        setupRecyclerUi()
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.backImageview.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.clearImageview.setOnClickListener {
            binding.searchEdittext.text?.clear()
        }
    }

    private fun setupRecyclerUi() {
        binding.ordersRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = interestAdapter
        }
    }

    private fun setupRecyclerAdapter() {
        interestAdapter = InterestAdapter {
        }
        interestsList.add(Interest("1", "Movies"))
        interestsList.add(Interest("2", "TV Show"))
        interestsList.add(Interest("3", "Series"))
        interestsList.add(Interest("4", "Books"))
        interestAdapter.setData(interestsList)
    }
}
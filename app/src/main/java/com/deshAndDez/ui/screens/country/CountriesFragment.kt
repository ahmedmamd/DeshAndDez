package com.deshAndDez.ui.screens.country

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.databinding.FragmentCountriesBinding
import com.deshAndDez.ui.adapters.*

class CountriesFragment : BaseFragment(R.layout.fragment_countries) {

    // Declare view and objects
    lateinit var binding: FragmentCountriesBinding

    //Departments
    lateinit var countryAdapter: CountryAdapter
    private val countriesList: MutableList<Country> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCountriesBinding.inflate(layoutInflater)
        setupRecyclerAdapter()
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
        binding.toolbar.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupRecyclerUi() {
        binding.ordersRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = countryAdapter
        }
    }

    private fun setupRecyclerAdapter() {
        countryAdapter = CountryAdapter {}
        countriesList.add(Country("1", "Argentina", R.drawable.country1))
        countriesList.add(Country("2", "Armenia", R.drawable.country2))
        countriesList.add(Country("3", "Angola", R.drawable.country3))
        countriesList.add(Country("4", "Andorra", R.drawable.country4))
        countriesList.add(Country("5", "Albania", R.drawable.country5))
        countriesList.add(Country("6", "Australia", R.drawable.country7))
        countryAdapter.setData(countriesList)
    }
}
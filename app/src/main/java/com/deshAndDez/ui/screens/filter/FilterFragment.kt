package com.deshAndDez.ui.screens.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.base.SelectionModel
import com.deshAndDez.databinding.FragmentFilterBinding
import com.deshAndDez.databinding.FragmentInterestsBinding
import com.deshAndDez.ui.adapters.SelectionAdapter
import com.deshAndDez.ui.screens.country.CountriesFragment
import com.deshAndDez.ui.screens.interest.InterrestsFragment
import com.deshAndDez.ui.screens.language.LanguagesFragment
import com.deshAndDez.ui.screens.report.ReportStepTwoFragment
import com.deshAndDez.utils.replaceFragment

class FilterFragment : BaseFragment(R.layout.fragment_filter) {
    // Declare view and objects
    lateinit var binding: FragmentFilterBinding

    lateinit var genderAdapter: SelectionAdapter
    private val genderList: MutableList<SelectionModel> = mutableListOf()

    lateinit var adDurationAdapter: SelectionAdapter
    private val adDurationList: MutableList<SelectionModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentFilterBinding.inflate(layoutInflater)
        setupGenderRecyclerAdapter()
        setupAdDurationRecyclerAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilterBinding.inflate(layoutInflater, container, false)
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
        setupGenderRecyclerUi()
        setupAdDurationRecyclerUi()
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.closeImageview.setOnClickListener {
            parentFragmentManager.popBackStack()
//            findNavController().popBackStack()
        }
        binding.languageLinearlayout.setOnClickListener {
            activity?.replaceFragment(LanguagesFragment(), R.id.fragment_container)
//            findNavController().navigate(R.id.languagesFragment)
        }
        binding.countryLinearlayout.setOnClickListener {
            activity?.replaceFragment(CountriesFragment(), R.id.fragment_container)
//            findNavController().navigate(R.id.countriesFragment)
        }
        binding.interestsLinearlayout.setOnClickListener {
            activity?.replaceFragment(InterrestsFragment(), R.id.fragment_container)
//            findNavController().navigate(R.id.interrestsFragment)
        }
    }

    private fun setupGenderRecyclerUi() {
        binding.genderRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity(),RecyclerView.HORIZONTAL,false)
            adapter = genderAdapter
        }
    }

    private fun setupGenderRecyclerAdapter() {
        genderAdapter = SelectionAdapter {
        }
        genderList.add(SelectionModel("1", getString(R.string.male)))
        genderList.add(SelectionModel("2", getString(R.string.female)))
        genderList.add(SelectionModel("3", getString(R.string.both)))
        genderAdapter.setData(genderList)
    }

    private fun setupAdDurationRecyclerUi() {
        binding.advertisementDurationRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity(),RecyclerView.HORIZONTAL,false)
            adapter = adDurationAdapter
        }
    }

    private fun setupAdDurationRecyclerAdapter() {
        adDurationAdapter = SelectionAdapter {
        }
        adDurationList.add(SelectionModel("1", getString(R.string._1_week)))
        adDurationList.add(SelectionModel("2", getString(R.string._2_weeks)))
        adDurationList.add(SelectionModel("3", getString(R.string._1_month)))
        adDurationList.add(SelectionModel("4", getString(R.string._2_months)))
        adDurationAdapter.setData(adDurationList)
    }
}
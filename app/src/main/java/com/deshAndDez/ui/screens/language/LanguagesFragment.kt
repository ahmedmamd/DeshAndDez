package com.deshAndDez.ui.screens.language

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.databinding.FragmentLanguageBinding
import com.deshAndDez.ui.adapters.Language
import com.deshAndDez.ui.adapters.LanguageAdapter
import com.deshAndDez.ui.adapters.User
import com.deshAndDez.ui.adapters.UsersAdapter

class LanguagesFragment : BaseFragment(R.layout.fragment_language) {

    // Declare view and objects
    lateinit var binding: FragmentLanguageBinding

    //Departments
    lateinit var languageAdapter: LanguageAdapter
    private val languageList: MutableList<Language> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLanguageBinding.inflate(layoutInflater)
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
        binding.toolbar.backImageview.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupRecyclerUi() {
        binding.ordersRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = languageAdapter
        }
    }

    private fun setupRecyclerAdapter() {
        languageAdapter = LanguageAdapter {
        }
        languageList.add(Language("1", "Arabic"))
        languageList.add(Language("2", "English"))
        languageList.add(Language("3", "Francais"))
        languageList.add(Language("4", "Spain"))
        languageList.add(Language("5", "Korean"))
        languageList.add(Language("6", "Italian"))
        languageAdapter.setData(languageList)
    }
}
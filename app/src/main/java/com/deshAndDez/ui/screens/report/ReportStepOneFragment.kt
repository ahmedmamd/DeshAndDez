package com.deshAndDez.ui.screens.report

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.databinding.FragmentReportStepOneBinding
import com.deshAndDez.ui.adapters.Report
import com.deshAndDez.ui.adapters.ReportAdapter
import com.deshAndDez.ui.adapters.User
import com.deshAndDez.ui.adapters.UsersAdapter

class ReportStepOneFragment : BaseFragment(R.layout.fragment_report_step_one) {

    // Declare view and objects
    lateinit var binding: FragmentReportStepOneBinding

    //Departments
    lateinit var reportsAdapter: ReportAdapter
    private val reportList: MutableList<Report> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentReportStepOneBinding.inflate(layoutInflater)
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
            adapter = reportsAdapter
        }
    }

    private fun setupRecyclerAdapter() {
        reportsAdapter = ReportAdapter {
        }
        reportList.add(Report("1", "it’s spam"))
        reportList.add(Report("2", "Nudity or sexual activity"))
        reportList.add(Report("3", "Hate speach or symbols"))
        reportList.add(Report("4", "Violence or dangerous organisations"))
        reportList.add(Report("5", "Sale ogillegal or regulated goods"))
        reportList.add(Report("6", "Bullying or harassment"))
        reportList.add(Report("7", "intellectual property violation"))
        reportList.add(Report("8", "Suicide or self-injury"))
        reportList.add(Report("9", "Eating disorders"))
        reportList.add(Report("10", "Scam or Fraud"))
        reportList.add(Report("11", "False information"))
        reportList.add(Report("12", "I just don’t like it"))
        reportsAdapter.setData(reportList)
    }
}
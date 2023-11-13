package com.deshAndDez.ui.screens.report

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.databinding.FragmentReportStepOneBinding
import com.deshAndDez.databinding.FragmentReportStepTwoBinding
import com.deshAndDez.ui.adapters.Report
import com.deshAndDez.ui.adapters.ReportAdapter
import com.deshAndDez.ui.adapters.User
import com.deshAndDez.ui.adapters.UsersAdapter

class ReportStepTwoFragment : BaseFragment(R.layout.fragment_report_step_two) {

    // Declare view and objects
    lateinit var binding: FragmentReportStepTwoBinding

    //Departments
    lateinit var reportsAdapter: ReportAdapter
    private val reportList: MutableList<Report> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentReportStepTwoBinding.inflate(layoutInflater)
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
        reportList.add(Report("1", "Race or ethnicity"))
        reportList.add(Report("2", "National origin"))
        reportList.add(Report("3", "Hate speech or symbols"))
        reportList.add(Report("4", "Social Caste"))
        reportList.add(Report("5", "Suicide or self-injury"))
        reportList.add(Report("6", "False information"))
        reportList.add(Report("7", "I just don’t like it"))
        reportsAdapter.setData(reportList)
    }
}
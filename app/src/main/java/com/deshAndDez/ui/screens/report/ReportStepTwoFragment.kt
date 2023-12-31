package com.deshAndDez.ui.screens.report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.databinding.FragmentReportStepTwoBinding
import com.deshAndDez.data.models.all_reels.report.Report
import com.deshAndDez.ui.adapters.ReportAdapter
import com.deshAndDez.utils.replaceFragment

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
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReportStepTwoBinding.inflate(layoutInflater, container, false)
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
//            findNavController().popBackStack()
            parentFragmentManager.popBackStack()
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
            activity?.replaceFragment(ReportStepThreeFragment(), R.id.fragment_container)

//            findNavController().navigate(R.id.reportStepThreeFragment)
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
package com.deshAndDez.ui.screens.report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.databinding.FragmentReportStepThreeBinding
import com.deshAndDez.utils.replaceFragment

class ReportStepThreeFragment : BaseFragment(R.layout.fragment_report_step_three) {

    // Declare view and objects
    lateinit var binding: FragmentReportStepThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentReportStepThreeBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReportStepThreeBinding.inflate(layoutInflater, container, false)
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
//            findNavController().popBackStack()
            parentFragmentManager.popBackStack()
        }
        binding.submitReportButton.setOnClickListener {
            activity?.replaceFragment(ReportStepFourFragment(), R.id.fragment_container)
//            findNavController().navigate(R.id.reportStepFourFragment)
        }
    }
}

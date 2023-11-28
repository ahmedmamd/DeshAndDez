package com.deshAndDez.ui.screens.report

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.databinding.*
import com.deshAndDez.ui.adapters.Report
import com.deshAndDez.ui.adapters.ReportAdapter
import com.deshAndDez.ui.adapters.User
import com.deshAndDez.ui.adapters.UsersAdapter
import com.deshAndDez.ui.fragment.HomeVediosFragment
import com.deshAndDez.utils.replaceFragment

class ReportStepFourFragment : BaseFragment(R.layout.fragment_report_step_four) {

    // Declare view and objects
    lateinit var binding: FragmentReportStepFourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentReportStepFourBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReportStepFourBinding.inflate(layoutInflater, container, false)
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
        binding.apply {
            doneButton.setOnClickListener {
                activity?.replaceFragment(HomeVediosFragment(), R.id.fragment_container)

//                findNavController().navigate(R.id.videoFragment)
            }
        }
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.backImageview.setOnClickListener {
            parentFragmentManager.popBackStack()
//            findNavController().popBackStack()
        }
        binding.doneButton.setOnClickListener {
        }
    }
}

package com.tmalty.ui.main.fragments.departments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.data.models.core.Department
import com.tmalty.data.models.core.SubDepartment
import com.tmalty.databinding.FragmentDepartmentsBinding
import com.tmalty.ui.main.fragments.departments.adapters.DepartmentsAdapter
import com.tmalty.ui.main.fragments.departments.adapters.SubDepartmentsAdapter

class DepartmentsFragment : BaseFragment(R.layout.fragment_departments) {

    // Declare view and objects
    lateinit var binding: FragmentDepartmentsBinding

    //Departments
    lateinit var departmentsAdapter: DepartmentsAdapter
    private val homeDepartmentsList: MutableList<Department> = mutableListOf()

    //Department With Services
    lateinit var subDepartmentsAdapter: SubDepartmentsAdapter
    private val subDepartmentsList: MutableList<SubDepartment> =
        mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDepartmentsAdapter()
        setupSubDepartmentsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDepartmentsBinding.bind(requireView())
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
        setupDepartmentsRecycler()
        setupSubDepartmentsRecycler()
    }



    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupDepartmentsRecycler() {
        binding.departmentsRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = departmentsAdapter
        }
    }

    private fun setupSubDepartmentsRecycler() {
        binding.subDepartmentsRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = subDepartmentsAdapter
        }
    }
    private fun setupDepartmentsAdapter() {
        departmentsAdapter = DepartmentsAdapter {
        }
        homeDepartmentsList.add(Department())
        homeDepartmentsList.add(Department())
        homeDepartmentsList.add(Department())
        homeDepartmentsList.add(Department())
        homeDepartmentsList.add(Department())
        homeDepartmentsList.add(Department())
        departmentsAdapter.setData(homeDepartmentsList)
    }

    private fun setupSubDepartmentsAdapter() {
        subDepartmentsAdapter = SubDepartmentsAdapter {
        }
        subDepartmentsList.add(SubDepartment())
        subDepartmentsList.add(SubDepartment())
        subDepartmentsList.add(SubDepartment())
        subDepartmentsList.add(SubDepartment())
        subDepartmentsList.add(SubDepartment())
        subDepartmentsAdapter.setData(subDepartmentsList)
    }

}
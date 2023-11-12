package com.deshAndDez.ui.screens.departments

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.data.models.core.Department
import com.deshAndDez.data.models.core.SubDepartment
import com.deshAndDez.databinding.FragmentDepartmentsBinding
import com.deshAndDez.ui.screens.departments.adapters.DepartmentsAdapter
import com.deshAndDez.ui.screens.departments.adapters.SubDepartmentsAdapter

class DepartmentsActivity : BaseActivity() {

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
        binding = FragmentDepartmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActivity()
    }


    //Entry point to this fragment
    private fun setupActivity() {
        setupUI()
        setupListeners()
    }

    // Set up the UI components
    private fun setupUI() {
        // Set up any UI-related configurations here
        setupDepartmentsAdapter()
        setupSubDepartmentsAdapter()
        setupDepartmentsRecycler()
        setupSubDepartmentsRecycler()
    }



    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.back.setOnClickListener {
            finish()
        }
    }

    private fun setupDepartmentsRecycler() {
        binding.departmentsRecycler.apply {
            layoutManager = LinearLayoutManager(this@DepartmentsActivity)
            adapter = departmentsAdapter
        }
    }

    private fun setupSubDepartmentsRecycler() {
        binding.subDepartmentsRecycler.apply {
            layoutManager = LinearLayoutManager(this@DepartmentsActivity)
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
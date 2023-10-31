package com.tmalty.ui.main.fragments.departments

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.base.BaseActivity
import com.tmalty.data.models.core.Department
import com.tmalty.data.models.core.SubDepartment
import com.tmalty.databinding.FragmentDepartmentsBinding
import com.tmalty.ui.main.fragments.departments.adapters.DepartmentsAdapter
import com.tmalty.ui.main.fragments.departments.adapters.SubDepartmentsAdapter

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
package com.tmalty.ui.main.fragments.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.data.models.core.Department
import com.tmalty.data.models.core.DepartmentWithServices
import com.tmalty.data.models.core.Service
import com.tmalty.databinding.FragmentHomeBinding
import com.tmalty.ui.main.fragments.home.adapters.HomeDepartmentWithServicesAdapter
import com.tmalty.ui.main.fragments.home.adapters.HomeDepartmentsAdapter

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    // Declare view and objects
    lateinit var binding: FragmentHomeBinding

    //Departments
    lateinit var departmentsAdapter: HomeDepartmentsAdapter
    private val homeDepartmentsList: MutableList<Department> = mutableListOf()

    //Department With Services
    lateinit var departmentWithServicesAdapter: HomeDepartmentWithServicesAdapter
    private val homeDepartmentsWithServicesList: MutableList<DepartmentWithServices> =
        mutableListOf()
    var isOpened = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpDepartmentsAdapter()
        setUpDepartmentsWithServicesAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(requireView())
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
        setUpDepartmentsRecycler()
        setUpDepartmentsWithServicesRecycler()
        setUpToolbar()
    }

    private fun setUpToolbar() {
        val toggle = ActionBarDrawerToggle(
            activity,
            binding.drawerLayout,
            binding.toolbar,
            R.string.open,
            R.string.close
        )
        toggle.syncState()
        binding.toolbar.setNavigationIcon(R.drawable.nav_icon)
        binding.darkMode.setAnimation(R.raw.darkmode)
        binding.darkMode.addLottieOnCompositionLoadedListener { composition ->
            val half = (composition.durationFrames * .5).toInt()
            binding.darkMode.setOnClickListener { v ->
                if (isOpened) {
                    binding.darkMode.setMinFrame(half)
                    binding.darkMode.setMaxFrame(composition.durationFrames.toInt())
                    isOpened = false
                } else {
                    binding.darkMode.setMinFrame(0)
                    binding.darkMode.setMaxFrame(half)
                    isOpened = true
                }
            }
        }
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.searchImageview.setOnClickListener {
            handleSearchClick()
        }
        binding.homeLinearlayout.setOnClickListener {
            handleHomeClick()
        }
        binding.departmentsLinearlayout.setOnClickListener {
            handleCategoriesClick()
        }
        binding.showAllDepartmentsTextView.setOnClickListener {
            handleCategoriesClick()
        }
        binding.ordersLinearlayout.setOnClickListener {
            handleOrdersClick()
        }
        binding.addServicesLinearlayout.setOnClickListener {
            handleAddServicesClick()
        }
        binding.profileLinearlayout.setOnClickListener {
            handleProfileClick()
        }
        binding.chatsLinearlayout.setOnClickListener {
            handleChatsClick()
        }
        binding.cartLinearlayout.setOnClickListener {
            handleCartClick()
        }
        binding.purchasesLinearlayout.setOnClickListener {
            handlePurchasesClick()
        }
        binding.moreLinearlayout.setOnClickListener {
            handleMoreClick()
        }
        binding.logoutLinearlayout.setOnClickListener {
            handleLogoutClick()
        }
    }

    private fun handleSearchClick() {
        findNavController().navigate(R.id.searchFragment)
    }

    private fun handleHomeClick() {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        isOpened = false
    }

    private fun handleCategoriesClick() {
        findNavController().navigate(R.id.departmentsFragment)
    }

    private fun handleOrdersClick() {
        findNavController().navigate(R.id.orderFragment)
    }

    private fun handleAddServicesClick() {

    }

    private fun handleProfileClick() {
        findNavController().navigate(R.id.customerProfileFragment)
    }

    private fun handleChatsClick() {
        findNavController().navigate(R.id.chatsFragment)
    }

    private fun handleCartClick() {
        findNavController().navigate(R.id.cartFragment)
    }

    private fun handlePurchasesClick() {
        findNavController().navigate(R.id.purchaseFragment)
    }

    private fun handleMoreClick() {
        findNavController().navigate(R.id.moreFragment)
    }

    private fun handleLogoutClick() {
        findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
    }

    private fun setUpDepartmentsRecycler() {
        binding.departmentsRecycler.apply {
            layoutManager = GridLayoutManager(requireActivity(), 3)
            adapter = departmentsAdapter
        }
    }

    private fun setUpDepartmentsAdapter() {
        departmentsAdapter = HomeDepartmentsAdapter { department ->
        }
        homeDepartmentsList.add(Department())
        homeDepartmentsList.add(Department())
        homeDepartmentsList.add(Department())
        homeDepartmentsList.add(Department())
        homeDepartmentsList.add(Department())
        homeDepartmentsList.add(Department())
        departmentsAdapter.setData(homeDepartmentsList)
    }

    private fun setUpDepartmentsWithServicesRecycler() {

        binding.departmentsWithServicesRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = departmentWithServicesAdapter
        }
    }

    private fun setUpDepartmentsWithServicesAdapter() {
        departmentWithServicesAdapter =
            HomeDepartmentWithServicesAdapter(
                onShowAllClicked = {

                },
                onServiceClicked = {
                    navigateToServiceDetails(it)
                })
        homeDepartmentsWithServicesList.add(DepartmentWithServices())
        homeDepartmentsWithServicesList.add(DepartmentWithServices())
        homeDepartmentsWithServicesList.add(DepartmentWithServices())
        homeDepartmentsWithServicesList.add(DepartmentWithServices())
        homeDepartmentsWithServicesList.add(DepartmentWithServices())
        homeDepartmentsWithServicesList.add(DepartmentWithServices())
        departmentWithServicesAdapter.setData(homeDepartmentsWithServicesList)
    }

    private fun navigateToServiceDetails(it: Service) {
        findNavController().navigate(R.id.serviceDetailsFragment)
    }


}
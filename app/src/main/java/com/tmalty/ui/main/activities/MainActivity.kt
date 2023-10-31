package com.tmalty.ui.main.activities

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseActivity
import com.tmalty.commons.extensions.startActivity
import com.tmalty.data.models.core.Department
import com.tmalty.data.models.core.DepartmentWithServices
import com.tmalty.data.models.core.Service
import com.tmalty.databinding.ActivityMainBinding
import com.tmalty.ui.auth.login.LoginActivity
import com.tmalty.ui.auth.profile.ProfileActivity
import com.tmalty.ui.main.addservice.AddServiceStepOneActivity
import com.tmalty.ui.main.fragments.cart.CartActivity
import com.tmalty.ui.main.fragments.chats.ChatsActivity
import com.tmalty.ui.main.fragments.departments.DepartmentsActivity
import com.tmalty.ui.main.fragments.home.adapters.HomeDepartmentWithServicesAdapter
import com.tmalty.ui.main.fragments.home.adapters.HomeDepartmentsAdapter
import com.tmalty.ui.main.fragments.more.MoreActivity
import com.tmalty.ui.main.fragments.orders.OrdersActivity
import com.tmalty.ui.main.fragments.purchase.PurchasesActivity
import com.tmalty.ui.main.fragments.search.SearchActivity
import com.tmalty.ui.main.fragments.servicedetails.ServiceDetailsActivity

class MainActivity : BaseActivity() {
    private val TAG = "MainActivity"

    //declare view and objects
    lateinit var binding: ActivityMainBinding

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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActivity()
    }


    //Entry point to this activity
    private fun setupActivity() {
        setupUI()
        setupListeners()
    }

    // Set up the UI components
    private fun setupUI() {
        // Set up any UI-related configurations here
        setUpDepartmentsAdapter()
        setUpDepartmentsWithServicesAdapter()
        setUpDepartmentsRecycler()
        setUpDepartmentsWithServicesRecycler()
        setUpToolbar()
    }

    private fun setUpToolbar() {
        val toggle = ActionBarDrawerToggle(
            this,
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
            handleDepartmentsClick()
        }
        binding.showAllDepartmentsTextView.setOnClickListener {
            handleDepartmentsClick()
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
        startActivity(SearchActivity::class.java)
    }

    private fun handleHomeClick() {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        isOpened = false
    }

    private fun handleDepartmentsClick() {
        startActivity(DepartmentsActivity::class.java)
    }

    private fun handleOrdersClick() {
        startActivity(OrdersActivity::class.java)
    }

    private fun handleAddServicesClick() {
        startActivity(AddServiceStepOneActivity::class.java)
    }

    private fun handleProfileClick() {
        startActivity(ProfileActivity::class.java)
    }

    private fun handleChatsClick() {
        startActivity(ChatsActivity::class.java)
    }

    private fun handleCartClick() {
        startActivity(CartActivity::class.java)
    }

    private fun handlePurchasesClick() {
        startActivity(PurchasesActivity::class.java)
    }

    private fun handleMoreClick() {
        startActivity(MoreActivity::class.java)
    }

    private fun handleLogoutClick() {
        startActivity(LoginActivity::class.java)
        finish()
    }

    private fun setUpDepartmentsRecycler() {
        binding.departmentsRecycler.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
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
            layoutManager = LinearLayoutManager(this@MainActivity)
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
        startActivity(ServiceDetailsActivity::class.java)
    }


}
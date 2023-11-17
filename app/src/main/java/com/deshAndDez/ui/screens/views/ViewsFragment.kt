package com.deshAndDez.ui.screens.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.databinding.FragmentLanguageBinding
import com.deshAndDez.databinding.FragmentLikesBinding
import com.deshAndDez.databinding.FragmentViewsBinding
import com.deshAndDez.ui.adapters.User
import com.deshAndDez.ui.adapters.UsersAdapter

class ViewsFragment : BaseFragment(R.layout.fragment_views) {
    // Declare view and objects
    lateinit var binding: FragmentViewsBinding

    //Departments
    lateinit var usersAdapter: UsersAdapter
    private val usersList: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentViewsBinding.inflate(layoutInflater)
        setupRecyclerAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewsBinding.inflate(layoutInflater, container, false)
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
            findNavController().popBackStack()
        }
    }

    private fun setupRecyclerUi() {
        binding.ordersRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = usersAdapter
        }
    }

    private fun setupRecyclerAdapter() {
        usersAdapter = UsersAdapter(onItemClicked = {}, onFollowClicked = {})
        usersList.add(User("1", "Ahmed Mohamed", "ahmedmohamed112", R.drawable.test_user_image1))
        usersList.add(User("2", "Mohamed Kamal", "mohamed33", R.drawable.test_user_image2))
        usersList.add(User("3", "Karim Ahmed", "karim66", R.drawable.test_user_image3))
        usersList.add(User("4", "Maged Ibraheem", "maged77", R.drawable.test_user_image1))
        usersAdapter.setData(usersList)
    }
}
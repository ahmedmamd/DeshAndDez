package com.deshAndDez.ui.screens.likes

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.databinding.FragmentLikesBinding
import com.deshAndDez.ui.adapters.User
import com.deshAndDez.ui.adapters.UsersAdapter

class LikesFragment : BaseFragment(R.layout.fragment_likes) {

    // Declare view and objects
    lateinit var binding: FragmentLikesBinding

    //Departments
    lateinit var usersAdapter: UsersAdapter
    private val likesList: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLikesBinding.inflate(layoutInflater)
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
            adapter = usersAdapter
        }
    }

    private fun setupRecyclerAdapter() {
        usersAdapter = UsersAdapter {
        }
        likesList.add(User("1","Ahmed Mohamed","ahmedmohamed112"))
        likesList.add(User("2","Mohamed Kamal","mohamed33"))
        likesList.add(User("3","Karim Ahmed","karim66"))
        likesList.add(User("4","Maged Ibraheem","maged77"))
        usersAdapter.setData(likesList)
    }
}
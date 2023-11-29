package com.deshAndDez.ui.screens.likes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.databinding.FragmentLikesBinding
import com.deshAndDez.data.models.all_reels.user.User
import com.deshAndDez.ui.adapters.UsersAdapter

class LikesFragment : BaseFragment(R.layout.fragment_likes) {

    // Declare view and objects
    lateinit var binding: FragmentLikesBinding

    //Departments
    lateinit var usersAdapter :UsersAdapter
    private val likesList: MutableList<User> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLikesBinding.inflate(layoutInflater, container, false)
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
        binding.toolbar.titleTextview.text = getString(R.string.likes)
        setupRecyclerUi()
        binding.toolbar.titleTextview.setOnFocusChangeListener { view, b ->
        }
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
            adapter = usersAdapter
        }
    }

    private fun setupRecyclerAdapter() {
        usersAdapter = UsersAdapter(onItemClicked = {}, onFollowClicked = {
        })
        likesList.add(User("1", "Ahmed Mohamed", "ahmedmohamed112", R.drawable.test_user_image1,false))
        likesList.add(User("2", "Mohamed Kamal", "mohamed33", R.drawable.test_user_image2,false))
        likesList.add(User("3", "Karim Ahmed", "karim66", R.drawable.test_user_image3,false))
        likesList.add(User("4", "Maged Ibraheem", "maged77", R.drawable.test_user_image2,true))
        usersAdapter.setData(likesList)
    }
}
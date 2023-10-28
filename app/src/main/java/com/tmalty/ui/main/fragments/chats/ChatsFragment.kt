package com.tmalty.ui.main.fragments.chats

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmalty.R
import com.tmalty.base.BaseFragment
import com.tmalty.data.models.core.Chat
import com.tmalty.databinding.FragmentChatsBinding
import com.tmalty.ui.main.fragments.chats.adapters.ChatsAdapter

class ChatsFragment : BaseFragment(R.layout.fragment_chats) {

    // Declare view and objects
    lateinit var binding: FragmentChatsBinding

    //Departments
    lateinit var chatsAdapter: ChatsAdapter
    private val chatsList: MutableList<Chat> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupChatsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChatsBinding.bind(requireView())
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
        setupChatsRecycler()
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupChatsRecycler() {
        binding.ordersRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = chatsAdapter
        }
    }

    private fun setupChatsAdapter() {
        chatsAdapter = ChatsAdapter {
        }
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsList.add(Chat())
        chatsAdapter.setData(chatsList)
    }
}
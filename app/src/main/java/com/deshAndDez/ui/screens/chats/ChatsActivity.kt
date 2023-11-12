package com.deshAndDez.ui.screens.chats

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.data.models.core.Chat
import com.deshAndDez.databinding.FragmentChatsBinding
import com.deshAndDez.ui.screens.chats.adapters.ChatsAdapter

class ChatsActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: FragmentChatsBinding

    //Departments
    lateinit var chatsAdapter: ChatsAdapter
    private val chatsList: MutableList<Chat> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentChatsBinding.inflate(layoutInflater)
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
        setupChatsAdapter()
        setupChatsRecycler()
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.back.setOnClickListener {
            finish()
        }
    }

    private fun setupChatsRecycler() {
        binding.ordersRecycler.apply {
            layoutManager = LinearLayoutManager(this@ChatsActivity)
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
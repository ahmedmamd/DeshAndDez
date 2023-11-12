package com.deshAndDez.ui.screens.addservice

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.commons.extensions.startActivity
import com.deshAndDez.data.models.core.Chat
import com.deshAndDez.databinding.ActivityAddServiceStepTwoBinding
import com.deshAndDez.ui.screens.addservice.adapters.GalleryAdapter

class AddServiceStepTwoActivity : BaseActivity() {

    // Declare view and objects
    lateinit var binding: ActivityAddServiceStepTwoBinding

    lateinit var galleryAdapter: GalleryAdapter
    private val galleryList: MutableList<Chat> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddServiceStepTwoBinding.inflate(layoutInflater)
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
        setupChatsAdapter()
        setupChatsRecycler()
    }

    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.toolbar.back.setOnClickListener {
            finish()
        }
        binding.previousButton.setOnClickListener {
            finish()
        }
        binding.nextButton.setOnClickListener {
            startActivity(AddServiceStepThreeActivity::class.java)
        }
    }

    private fun setupChatsRecycler() {
        binding.recycler.apply {
            layoutManager =
                LinearLayoutManager(this@AddServiceStepTwoActivity, RecyclerView.HORIZONTAL, false)
            adapter = galleryAdapter
        }
    }

    private fun setupChatsAdapter() {
        galleryAdapter = GalleryAdapter {
        }
        galleryList.add(Chat())
        galleryList.add(Chat())
        galleryList.add(Chat())
        galleryList.add(Chat())
        galleryList.add(Chat())
        galleryAdapter.setData(galleryList)
    }
}
package com.tmalty.ui.main.addservice

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tmalty.base.BaseActivity
import com.tmalty.commons.extensions.startActivity
import com.tmalty.data.models.core.Chat
import com.tmalty.databinding.ActivityAddServiceStepOneBinding
import com.tmalty.databinding.ActivityAddServiceStepTwoBinding
import com.tmalty.databinding.FragmentLoginBinding
import com.tmalty.ui.auth.create_account.SignUpActivity
import com.tmalty.ui.auth.forgetpassword.ForgetPasswordActivity
import com.tmalty.ui.main.activities.MainActivity
import com.tmalty.ui.main.addservice.adapters.GalleryAdapter
import com.tmalty.ui.main.fragments.chats.adapters.ChatsAdapter

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
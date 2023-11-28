package com.deshAndDez.ui.dialogs

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.R
import com.deshAndDez.databinding.SheetLayoutCommentsBinding
import com.deshAndDez.ui.adapters.Comment
import com.deshAndDez.ui.adapters.CommentsAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog

class CommentsSheet(private val screenContext: Context) :
    BottomSheetDialog(screenContext, R.style.BottomSheetDialog) {
    var binding: SheetLayoutCommentsBinding =
        SheetLayoutCommentsBinding.inflate(LayoutInflater.from(screenContext))

    private lateinit var commentsAdapter : CommentsAdapter
    private val commentsList = ArrayList<Comment>()

    init {
        setupBottomSheet()
    }

    //Entry point to this bottom sheet dialog
    private fun setupBottomSheet() {
        setupUI()
        setupListeners()
    }

    // Set up the UI components
    private fun setupUI() {
        // Set up any UI-related configurations here
        setContentView(binding.root)
        setCancelable(true)
        setUpComments()
    }

    private fun setUpComments() {
        commentsAdapter = CommentsAdapter(onItemClicked = {})
        commentsList.add(Comment(image = R.drawable.test_user_image2))
        commentsList.add(Comment(image = R.drawable.test_user_image1))
        commentsList.add(Comment(image = R.drawable.test_user_image2))
        commentsList.add(Comment(image = R.drawable.test_user_image3))
        commentsList.add(Comment(image = R.drawable.test_user_image1))

        commentsAdapter.setData(commentsList)
        binding.recycler.apply {
            adapter = commentsAdapter
            layoutManager = LinearLayoutManager(screenContext)
        }
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {

    }
}
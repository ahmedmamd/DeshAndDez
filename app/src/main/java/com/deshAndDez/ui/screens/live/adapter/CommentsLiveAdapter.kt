package com.deshAndDez.ui.screens.live.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.databinding.ItemCommentLiveBinding
import com.deshAndDez.databinding.RecyclerItemLayoutCommentBinding
import com.deshAndDez.ui.adapters.Comment

class CommentsLiveAdapter() :
    CustomBaseAdapter<Comment, CommentsLiveAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_comment_live, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCommentLiveBinding.bind(itemView)
        fun bind(item: Comment) {
            item.image?.let {
                binding.ivUserAvatar.setImageResource(it)
            }

        }
    }
}
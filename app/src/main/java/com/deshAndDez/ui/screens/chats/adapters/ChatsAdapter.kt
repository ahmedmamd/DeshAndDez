package com.deshAndDez.ui.screens.chats.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.commons.helpers.Utils
import com.deshAndDez.data.models.core.*
import com.deshAndDez.databinding.*

class ChatsAdapter(private val onItemClicked: (Chat) -> Unit) :
    CustomBaseAdapter<Chat, ChatsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout_chat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutChatBinding.bind(itemView)
        fun bind(item: Chat) {
            if ((position % 2) == 0)
                setupUnreadMessageUi(item)
            itemView.setOnClickListener {
                onItemClicked(item)
            }
        }

        private fun setupUnreadMessageUi(item: Chat) {
            binding.unreadMessagesCountTextview.visibility = View.VISIBLE
            binding.messageTextview.setTextColor(Utils.getColorTintList(itemView.context,R.color.text_color_primary))
        }

    }
}
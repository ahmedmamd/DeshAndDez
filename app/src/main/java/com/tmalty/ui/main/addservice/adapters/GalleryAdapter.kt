package com.tmalty.ui.main.addservice.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tmalty.R
import com.tmalty.base.adapters.CustomBaseAdapter
import com.tmalty.commons.helpers.Utils
import com.tmalty.data.models.core.*
import com.tmalty.databinding.*

class GalleryAdapter(private val onItemClicked: (Chat) -> Unit) :
    CustomBaseAdapter<Chat, GalleryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout_service_gallery, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutServiceGalleryBinding.bind(itemView)
        fun bind(item: Chat) {
            itemView.setOnClickListener {
                onItemClicked(item)
            }
            binding.removeImageview.setOnClickListener {
                removeItem(position)
            }
        }
    }
}
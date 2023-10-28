package com.tmalty.ui.main.fragments.servicedetails.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tmalty.R
import com.tmalty.base.adapters.CustomBaseAdapter
import com.tmalty.data.models.core.Purchase
import com.tmalty.data.models.core.Reviews
import com.tmalty.databinding.RecyclerItemLayoutPurchaseBinding
import com.tmalty.databinding.RecyclerItemLayoutReviewBinding

class ReviewsAdapter() :
    CustomBaseAdapter<Reviews, ReviewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout_review, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutReviewBinding.bind(itemView)
        fun bind(item: Reviews) {
        }
    }
}
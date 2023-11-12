package com.deshAndDez.ui.screens.orders.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.RatingModel
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.databinding.*

class ReviewSelectionAdapter(private val onItemClicked: (RatingModel, Boolean) -> Unit) :
    CustomBaseAdapter<RatingModel, ReviewSelectionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout_review_selection, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutReviewSelectionBinding.bind(itemView)
        fun bind(item: RatingModel) {
            binding.ratingBar.rating = item.rating!!.toFloat()
            itemView.setOnClickListener {
                onItemClicked(item,binding.radio.isChecked)
            }
        }

    }
}
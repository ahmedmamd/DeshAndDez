package com.deshAndDez.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.commons.helpers.Utils
import com.deshAndDez.data.models.all_reels.intersted.Interest
import com.deshAndDez.databinding.RecyclerItemLayoutInterestBinding

class InterestAdapter(private val onItemClicked: (Interest) -> Unit) :
    CustomBaseAdapter<Interest, InterestAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout_interest, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutInterestBinding.bind(itemView)
        fun bind(item: Interest) {
            binding.title.text = item.text
            if (position == currentSelectedPosition) {
                binding.selection.backgroundTintList =
                    Utils.getColorTintList(itemView.context, R.color.gold)
            } else
                binding.selection.backgroundTintList =
                    Utils.getColorTintList(itemView.context, R.color.light_grey)
            itemView.setOnClickListener {
                clickItem(position) {
                    onItemClicked(item)
                }
            }
        }
    }
}
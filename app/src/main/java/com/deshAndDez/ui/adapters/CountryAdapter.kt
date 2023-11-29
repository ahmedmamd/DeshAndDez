package com.deshAndDez.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.commons.helpers.Utils
import com.deshAndDez.data.models.all_reels.country.Country
import com.deshAndDez.databinding.RecyclerItemLayoutCountryBinding

class CountryAdapter(private val onItemClicked: (Country) -> Unit) :
    CustomBaseAdapter<Country, CountryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout_country, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutCountryBinding.bind(itemView)
        fun bind(item: Country) {
            binding.title.text = item.text
            item.image?.let {
                binding.image.setImageResource(it)
            }
            if (position == currentSelectedPosition) {
                binding.selection.backgroundTintList =
                    Utils.getColorTintList(itemView.context, R.color.gold)
            } else binding.selection.backgroundTintList =
                Utils.getColorTintList(itemView.context, R.color.light_grey)
            itemView.setOnClickListener {
                clickItem(position) {
                    onItemClicked(item)
                }
            }
        }
    }
}
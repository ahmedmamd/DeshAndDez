package com.deshAndDez.ui.adapters

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.SelectionModel
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.commons.helpers.Utils
import com.deshAndDez.databinding.RecyclerItemLayoutCountryBinding
import com.deshAndDez.databinding.RecyclerItemLayoutReportBinding
import com.deshAndDez.databinding.RecyclerItemLayoutSelectionBinding

class SelectionAdapter(private val onItemClicked: (SelectionModel) -> Unit) :
    CustomBaseAdapter<SelectionModel, SelectionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout_selection, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutSelectionBinding.bind(itemView)
        fun bind(item: SelectionModel) {
            binding.container.text = item.name
            if (position == currentSelectedPosition) {
                binding.container.setBackgroundResource(R.drawable.gold_round_background)
                binding.container.setTextColor(
                    Utils.getColorTintList(
                        itemView.context,
                        R.color.text_primary
                    )
                )
                binding.container.setTypeface(null, Typeface.BOLD)
            } else {
                binding.container.setBackgroundResource(R.drawable.gold_round_stroke_background)
                binding.container.setTextColor(
                    Utils.getColorTintList(
                        itemView.context,
                        R.color.gold
                    )
                )
                binding.container.setTypeface(null, Typeface.NORMAL)
            }
            itemView.setOnClickListener {
                clickItem(position) {
                    onItemClicked(item)
                }
            }
        }
    }
}
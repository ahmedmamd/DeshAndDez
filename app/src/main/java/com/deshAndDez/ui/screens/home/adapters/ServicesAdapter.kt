package com.deshAndDez.ui.screens.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.data.models.core.Service
import com.deshAndDez.databinding.RecyclerItemLayoutServiceForLinearHorizontalBinding

class ServicesAdapter(private val onItemClicked: (Service) -> Unit) :
    CustomBaseAdapter<Service, ServicesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout_service_for_linear_horizontal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutServiceForLinearHorizontalBinding.bind(itemView)
        fun bind(item: Service) {
            itemView.setOnClickListener {
                onItemClicked(item)
            }
        }

    }
}
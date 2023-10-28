package com.tmalty.ui.main.fragments.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tmalty.R
import com.tmalty.base.adapters.CustomBaseAdapter
import com.tmalty.data.models.core.Department
import com.tmalty.data.models.core.DepartmentWithServices
import com.tmalty.data.models.core.Service
import com.tmalty.databinding.RecyclerItemLayoutHomeDepartmentBinding
import com.tmalty.databinding.RecyclerItemLayoutHomeDepartmentWithServicesBinding
import com.tmalty.databinding.RecyclerItemLayoutServiceForLinearHorizontalBinding

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
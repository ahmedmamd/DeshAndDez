package com.tmalty.ui.main.fragments.search.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tmalty.R
import com.tmalty.base.adapters.CustomBaseAdapter
import com.tmalty.data.models.core.Department
import com.tmalty.data.models.core.Service
import com.tmalty.databinding.RecyclerItemLayoutServiceForGridBinding
import com.tmalty.databinding.RecyclerItemLayoutSubDepartmentServicesBinding
import com.tmalty.databinding.RecyclerItemLayoutSubDepartmentsBinding

class SearchAdapter(private val onItemClicked: (Service) -> Unit) :
    CustomBaseAdapter<Service, SearchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout_service_for_grid, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutServiceForGridBinding.bind(itemView)
        fun bind(item: Service) {

            itemView.setOnClickListener {

            }
        }
    }
}
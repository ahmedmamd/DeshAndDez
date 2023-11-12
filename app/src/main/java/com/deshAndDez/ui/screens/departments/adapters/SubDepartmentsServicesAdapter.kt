package com.deshAndDez.ui.screens.departments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.data.models.core.Service
import com.deshAndDez.databinding.RecyclerItemLayoutSubDepartmentServicesBinding

class SubDepartmentsServicesAdapter(private val onItemClicked: (Service) -> Unit) :
    CustomBaseAdapter<Service, SubDepartmentsServicesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout_sub_department_services, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutSubDepartmentServicesBinding.bind(itemView)
        fun bind(item: Service) {

            itemView.setOnClickListener {

            }
        }
    }
}
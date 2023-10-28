package com.tmalty.ui.main.fragments.servicedetails.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tmalty.R
import com.tmalty.base.adapters.CustomBaseAdapter
import com.tmalty.data.models.core.Department
import com.tmalty.data.models.core.Service
import com.tmalty.data.models.core.ServiceUpgrade
import com.tmalty.databinding.RecyclerItemLayoutServiceForGridBinding
import com.tmalty.databinding.RecyclerItemLayoutServiceUpgradeBinding
import com.tmalty.databinding.RecyclerItemLayoutSubDepartmentServicesBinding
import com.tmalty.databinding.RecyclerItemLayoutSubDepartmentsBinding

class ServiceUpgradeAdapter(private val onItemClicked: (ServiceUpgrade) -> Unit) :
    CustomBaseAdapter<ServiceUpgrade, ServiceUpgradeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout_service_upgrade, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutServiceUpgradeBinding.bind(itemView)
        fun bind(item: ServiceUpgrade) {
            itemView.setOnClickListener {
                binding.checkbox.isChecked = !binding.checkbox.isChecked
            }
        }
    }
}
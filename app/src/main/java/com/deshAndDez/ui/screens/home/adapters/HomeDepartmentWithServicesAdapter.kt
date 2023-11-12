package com.deshAndDez.ui.screens.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.commons.helpers.Utils
import com.deshAndDez.data.models.core.DepartmentWithServices
import com.deshAndDez.data.models.core.Service
import com.deshAndDez.databinding.RecyclerItemLayoutHomeDepartmentWithServicesBinding

class HomeDepartmentWithServicesAdapter(
    private val onShowAllClicked: (DepartmentWithServices) -> Unit,
    private val onServiceClicked: (Service) -> Unit
) : CustomBaseAdapter<DepartmentWithServices, HomeDepartmentWithServicesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout_home_department_with_services, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutHomeDepartmentWithServicesBinding.bind(itemView)
        fun bind(item: DepartmentWithServices) {
            setUpServicesRecycler(item)
            setUpBackground()
            binding.showAllServicesTextView.setOnClickListener {
                onShowAllClicked(item)
            }
        }

        private fun setUpBackground() {
            if ((position % 2) == 0) {
                binding.container.backgroundTintList =
                    Utils.getColorTintList(itemView.context, R.color.background_color_main)
            } else {
                binding.container.backgroundTintList =
                    Utils.getColorTintList(itemView.context, R.color.background_color_secondary)
            }
        }

        private fun setUpServicesRecycler(item: DepartmentWithServices) {
            val servicesAdapter = ServicesAdapter { service ->
                onServiceClicked(service)
            }
            servicesAdapter.setData(item.services!!)
            binding.servicesRecycler.apply {
                layoutManager =
                    LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
                adapter = servicesAdapter
                // Add scroll listener to automatically load more data
            }
        }

    }
}
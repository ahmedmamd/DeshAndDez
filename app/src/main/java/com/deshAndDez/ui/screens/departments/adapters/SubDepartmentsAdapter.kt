package com.deshAndDez.ui.screens.departments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.data.models.core.SubDepartment
import com.deshAndDez.databinding.RecyclerItemLayoutSubDepartmentsBinding

class SubDepartmentsAdapter(private val onItemClicked: (SubDepartment) -> Unit) :
    CustomBaseAdapter<SubDepartment, SubDepartmentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout_sub_departments, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutSubDepartmentsBinding.bind(itemView)
        fun bind(item: SubDepartment) {
            setupServicesRecycler(item)
            setupExpandItemUi(item)
            itemView.setOnClickListener {
                clickItem(position, onItemClicked = {
                    onItemClicked(item)
                })
            }
        }

        private fun setupServicesRecycler(item: SubDepartment) {
            item.services?.let {
                val subDepartmentsServicesAdapter = SubDepartmentsServicesAdapter {
                }
                subDepartmentsServicesAdapter.setData(item.services!!)
                binding.servicesRecycler.apply {
                    adapter = subDepartmentsServicesAdapter
                    layoutManager = LinearLayoutManager(itemView.context)
                }
            }
        }

        private fun setupExpandItemUi(item: SubDepartment) {
            if (currentSelectedPosition == position)
                binding.viewExpand.toggle()
            else
                binding.viewExpand.collapse()

        }
    }
}
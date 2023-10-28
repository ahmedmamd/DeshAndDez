package com.tmalty.ui.main.fragments.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tmalty.R
import com.tmalty.base.adapters.CustomBaseAdapter
import com.tmalty.data.models.core.Department
import com.tmalty.databinding.RecyclerItemLayoutHomeDepartmentBinding

class HomeDepartmentsAdapter(private val onItemClicked: (Department) -> Unit) :
    CustomBaseAdapter<Department, HomeDepartmentsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout_home_department, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutHomeDepartmentBinding.bind(itemView)
        fun bind(item: Department) {
            itemView.setOnClickListener {
                onItemClicked(item)
            }
        }

    }
}
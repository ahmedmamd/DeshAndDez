package com.tmalty.ui.main.fragments.orders.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tmalty.R
import com.tmalty.base.adapters.CustomBaseAdapter
import com.tmalty.data.models.core.*
import com.tmalty.databinding.*

class OrdersAdapter(private val onItemClicked: (Order) -> Unit) :
    CustomBaseAdapter<Order, OrdersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout_orders, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutOrdersBinding.bind(itemView)
        fun bind(item: Order) {
            itemView.setOnClickListener {
                onItemClicked(item)
            }
        }

    }
}
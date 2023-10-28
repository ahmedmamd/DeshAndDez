package com.tmalty.ui.main.fragments.cart.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tmalty.R
import com.tmalty.base.adapters.CustomBaseAdapter
import com.tmalty.data.models.core.Cart
import com.tmalty.data.models.core.ServiceUpgrade
import com.tmalty.databinding.RecyclerItemLayoutCartBinding
import com.tmalty.ui.main.fragments.servicedetails.adapters.ServiceUpgradeAdapter

class CartAdapter(private val onItemClicked: (Cart) -> Unit) :
    CustomBaseAdapter<Cart, CartAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout_cart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutCartBinding.bind(itemView)
        fun bind(item: Cart) {
            setupServiceUpgrades(item)
            binding.numberPicker.setupNumberPicker(1, 100) { newValue -> }
            itemView.setOnClickListener {
                onItemClicked(item)
            }
            binding.removeImageview.setOnClickListener {
                removeItem(position)
            }
        }

        private fun setupServiceUpgrades(item: Cart) {
            val serviceUpgradesAdapter = ServiceUpgradeAdapter {
            }
            val serviceUpgradesList = mutableListOf<ServiceUpgrade>()
            serviceUpgradesList.add(ServiceUpgrade())
            serviceUpgradesList.add(ServiceUpgrade())
            serviceUpgradesList.add(ServiceUpgrade())
            serviceUpgradesAdapter.setData(serviceUpgradesList)
            binding.serviceUpgradesRecycler.apply {
                layoutManager = LinearLayoutManager(itemView.context)
                adapter = serviceUpgradesAdapter
            }
        }
    }
}
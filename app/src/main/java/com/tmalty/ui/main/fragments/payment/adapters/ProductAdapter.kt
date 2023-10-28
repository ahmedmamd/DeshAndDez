package com.tmalty.ui.main.fragments.payment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tmalty.R
import com.tmalty.base.adapters.CustomBaseAdapter
import com.tmalty.data.models.core.Cart
import com.tmalty.data.models.core.Product
import com.tmalty.data.models.core.ServiceUpgrade
import com.tmalty.databinding.RecyclerItemLayoutCartBinding
import com.tmalty.databinding.RecyclerItemLayoutPaymentProductsBinding
import com.tmalty.ui.main.fragments.servicedetails.adapters.ServiceUpgradeAdapter

class ProductAdapter() :
    CustomBaseAdapter<Product, ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout_payment_products, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutPaymentProductsBinding.bind(itemView)
        fun bind(item: Product) {
        }
    }
}
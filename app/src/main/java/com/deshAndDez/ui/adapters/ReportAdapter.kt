package com.deshAndDez.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.data.models.all_reels.report.Report
import com.deshAndDez.databinding.RecyclerItemLayoutReportBinding

class ReportAdapter(private val onItemClicked: (Report) -> Unit) :
    CustomBaseAdapter<Report, ReportAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout_report, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        private val binding = RecyclerItemLayoutReportBinding.bind(itemView)
        fun bind(item: Report) {
            binding.reportText.text = item.text
            itemView.setOnClickListener {
                onItemClicked(item)
            }
        }
    }
}
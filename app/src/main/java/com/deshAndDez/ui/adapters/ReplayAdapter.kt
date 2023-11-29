package com.deshAndDez.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.data.models.all_reels.comments.replay.Replay
import com.deshAndDez.databinding.RecyclerItemLayoutReplayBinding

class ReplayAdapter(private val onItemClicked: (Replay) -> Unit) :
    CustomBaseAdapter<Replay, ReplayAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout_replay, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutReplayBinding.bind(itemView)
        fun bind(item: Replay) {
            item.image?.let {
                binding.image.setImageResource(it)
            }
            itemView.setOnClickListener {
                onItemClicked(item)
            }

        }
    }
}
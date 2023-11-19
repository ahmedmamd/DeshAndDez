package com.deshAndDez.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.databinding.RecyclerItemLayoutCommentBinding
import com.deshAndDez.databinding.RecyclerItemLayoutUsersBinding

class CommentsAdapter(private val onItemClicked: (Comment) -> Unit) :
    CustomBaseAdapter<Comment, CommentsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout_comment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemLayoutCommentBinding.bind(itemView)
        fun bind(item: Comment) {
            item.image?.let {
                binding.image.setImageResource(it)
            }
            itemView.setOnClickListener {
                onItemClicked(item)
            }
            binding.hideRepliesLinearlayout.setOnClickListener {
                binding.hideRepliesLinearlayout.visibility = View.GONE
                binding.replayRecycler.visibility = View.GONE
                binding.viewRepliesLinearlayout.visibility = View.VISIBLE
            }
            binding.viewRepliesLinearlayout.setOnClickListener {
                binding.viewRepliesLinearlayout.visibility = View.GONE
                binding.hideRepliesLinearlayout.visibility = View.VISIBLE
                binding.replayRecycler.visibility = View.VISIBLE
            }
            setUpReplies(ArrayList())
        }

        private fun setUpReplies(RepliesList : ArrayList<Replay>) {
            val replayAdapter = ReplayAdapter(onItemClicked = {})
            RepliesList.add(Replay(image = R.drawable.test_user_image2))
            RepliesList.add(Replay(image = R.drawable.test_user_image1))
            RepliesList.add(Replay(image = R.drawable.test_user_image2))
            RepliesList.add(Replay(image = R.drawable.test_user_image3))
            RepliesList.add(Replay(image = R.drawable.test_user_image2))
            RepliesList.add(Replay(image = R.drawable.test_user_image3))
            replayAdapter.setData(RepliesList)
            binding.replayRecycler.apply {
                adapter = replayAdapter
                layoutManager = LinearLayoutManager(itemView.context)
            }
        }
    }
}
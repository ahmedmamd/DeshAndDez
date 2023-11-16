package com.deshAndDez.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.databinding.ItemReelsBinding
import com.deshAndDez.databinding.RecyclerItemLayoutUsersBinding

private const val TAG = "UsersAdapter"
class UsersAdapter(private val onItemClicked: (User) -> Unit) :
    CustomBaseAdapter<User, UsersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerItemLayoutUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e(TAG, "onBindViewHolder: sdjvjksdnjkvnkasdnvjks", )
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(val binding: RecyclerItemLayoutUsersBinding) : RecyclerView.ViewHolder(binding.root) {
//        private val binding = RecyclerItemLayoutUsersBinding.bind(itemView)
        fun bind(item: User) {
            Log.e(TAG, "bindlist: ${item}")
            binding.nameTextview.text = item.name
            binding.usernameTextview.text = item.username
            item.image?.let {
                binding.image.setImageResource(it)
            }
            itemView.setOnClickListener {
                onItemClicked(item)
            }
            binding.followButton.setOnClickListener {
                removeItem(position)
            }
        }
    }
}
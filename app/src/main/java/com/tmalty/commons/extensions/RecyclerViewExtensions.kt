package com.tmalty.commons.extensions

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder

// (Int) in  onLoadMore is for lastVisibleItemPosition
fun RecyclerView.loadMoreData(onLoadMore: (Int) -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
            val totalItemCount = layoutManager.itemCount
            onLoadMore(lastVisibleItemPosition)
//            if (!stopLoading && lastVisibleItemPosition == totalItemCount - 2) {
//            }
        }
    })
}

fun RecyclerView.setupRecycler(adapter:RecyclerView.Adapter<ViewHolder>,layoutManager: LayoutManager){
    this.adapter = adapter
    this.layoutManager = layoutManager
}
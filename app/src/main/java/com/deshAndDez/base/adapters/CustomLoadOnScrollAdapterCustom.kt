package com.deshAndDez.base.adapters

import androidx.recyclerview.widget.RecyclerView

abstract class CustomLoadOnScrollAdapterCustom<T, VH : RecyclerView.ViewHolder> : CustomBaseAdapter<T, VH>() {
    private var isLoading: Boolean = false
    private var loadMoreListener: OnLoadMoreListener? = null

    interface OnLoadMoreListener {
        fun onLoadMore()
    }

    fun setLoadMoreListener(listener: OnLoadMoreListener) {
        loadMoreListener = listener
    }

    fun setLoaded() {
        isLoading = false
    }

    fun setLoading() {
        isLoading = true
    }

    fun isLoading(): Boolean {
        return isLoading
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        if (position == itemCount - 1 && isLoading && loadMoreListener != null) {
            loadMoreListener?.onLoadMore()
        }
    }
}
package com.tmalty.commons.helpers

import androidx.core.widget.NestedScrollView

class LoadOnScrollHelper {
    // Set Up Load On Scroll Listener
    companion object {
        private var stopScroll = false
        private var mSkip = 0
        private var take = 0
        private var onScrollChangeListener: NestedScrollView.OnScrollChangeListener? = null
        private var nestedScrollView: NestedScrollView? = null
        fun setUpLoadOnScrollListener(
            scrollView: NestedScrollView,
            onLoadMore: () -> Unit
        ) {
            this.nestedScrollView = scrollView
            onScrollChangeListener =
                NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                    if (v.getChildAt(v.childCount - 1) != null) {
                        if (scrollY >= v.getChildAt(v.childCount - 1).measuredHeight - v.measuredHeight &&
                            scrollY > oldScrollY
                        ) {
                            if (!stopScroll) {
                                onLoadMore()
                            }
                        }
                    }
                }
            scrollView.setOnScrollChangeListener(onScrollChangeListener)
        }

        // Stop Scroll If Data Ended and update new skip
        fun updateScrollStatus(size: Int, take: Int): Int {
            stopScroll = size < take
            mSkip += take
            nestedScrollView?.setOnScrollChangeListener(onScrollChangeListener)
            return mSkip
        }
    }
}
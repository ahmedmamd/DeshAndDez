package com.tmalty.ui.customviews.swipeRefresh

import android.content.Context
import android.util.AttributeSet
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.tmalty.R

class CustomSwipeRefreshLayout(context: Context, attrs: AttributeSet?) :
    SwipeRefreshLayout(context, attrs) {
        init {
            setColorSchemeColors(context.resources.getColor(R.color.colorAccent))
        }
}
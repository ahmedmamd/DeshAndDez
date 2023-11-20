package com.deshAndDez.commons.helpers.viewpager2_autoscroll_utils

import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object PagerAutoScrollJob {
    private const val TAG = "PagerAutoScrollJob"
    private var autoScrollJob: Job? = null


    private fun setupExceptionHandler(): CoroutineExceptionHandler {
        return CoroutineExceptionHandler { coroutineContext, throwable ->
            throwable.message?.let { message ->
                Log.e(TAG, message)
            }
            throwable.printStackTrace()
        }
    }

    fun startAutoScroll(coroutineScope: CoroutineScope, viewPager2: ViewPager2) {
        autoScrollJob?.cancel()
        autoScrollJob = coroutineScope.launch(Dispatchers.IO + setupExceptionHandler()) {
            while (isActive) {
                delay(3000)
                withContext(Dispatchers.Main) {
                    viewPager2.adapter?.itemCount?.let { itemCount ->
                        viewPager2.setCurrentItem((viewPager2.currentItem + 1) % itemCount, true)
                    }
                }
            }
        }
    }

    fun stopAutoScroll() {
        autoScrollJob?.cancel()
    }

}
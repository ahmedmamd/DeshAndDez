package com.tmalty.commons.extensions

import android.view.View
import android.view.ViewParent
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

fun BottomSheetDialog.setUpSheetUi(viewParent: ViewParent) {
    val displayMetrics = context.resources.displayMetrics
    val height = displayMetrics.heightPixels
    val mBehavior: BottomSheetBehavior<*> =
        BottomSheetBehavior.from(viewParent as View)
    mBehavior.peekHeight = height
}
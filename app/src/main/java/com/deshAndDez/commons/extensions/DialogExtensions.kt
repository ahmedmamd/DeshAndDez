package com.deshAndDez.commons.extensions

import android.app.Dialog
import android.view.WindowManager

fun Dialog.setUpSheetUi(height: Int? = null) {
    window!!.setLayout(
        WindowManager.LayoutParams.MATCH_PARENT,
        height ?: WindowManager.LayoutParams.WRAP_CONTENT
    )
    window!!.setBackgroundDrawableResource(android.R.color.transparent)
}
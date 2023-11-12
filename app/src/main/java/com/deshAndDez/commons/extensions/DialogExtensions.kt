package com.deshAndDez.commons.extensions

import android.app.Dialog
import android.view.WindowManager

fun Dialog.setUpSheetUi() {
    window!!.setLayout(
        WindowManager.LayoutParams.MATCH_PARENT,
        WindowManager.LayoutParams.WRAP_CONTENT
    )
    window!!.setBackgroundDrawableResource(android.R.color.transparent)
}
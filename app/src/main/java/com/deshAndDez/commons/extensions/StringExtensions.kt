package com.deshAndDez.commons.extensions

import com.google.gson.Gson
import com.deshAndDez.commons.models.ResponseErrorResult

fun String.isEmailValid(): Boolean {
    // Custom logic to validate email
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.convertToResponseErrorResult(): ResponseErrorResult {
    return Gson().fromJson(this, ResponseErrorResult::class.java)
}

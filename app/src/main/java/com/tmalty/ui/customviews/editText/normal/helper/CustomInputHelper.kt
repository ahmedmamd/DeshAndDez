package com.tmalty.ui.customviews.editText.normal.helper

import android.content.Context
import com.tmalty.R
import com.tmalty.ui.customviews.editText.normal.BaseInput

class CustomInputHelper {
    companion object {
        // set up typingCallback for inputs views
        fun setUpInputsTypingCallback(inputViews: ArrayList<BaseInput>) {
            inputViews.forEach { inputView ->
                inputView!!.setOnTextTyping(
                    object : BaseInput.TypingCallback {
                        override fun onTyping(text: String) {
                        }
                    })
            }
        }
        fun checkIfInputsIsValid(
            context: Context,
            inputViews: ArrayList<BaseInput>
        ): Boolean {
            var inputsViews = inputViews
            inputsViews.forEach { inputView ->
                if (!inputView!!.isValid) {
                    inputView!!.requestFocus()
                    inputView!!.error = context.getString(R.string.required)
                    return false
                }
            }
            return true
        }
    }
}

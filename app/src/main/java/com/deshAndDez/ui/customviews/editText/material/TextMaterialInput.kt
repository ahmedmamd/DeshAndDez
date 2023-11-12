package com.deshAndDez.ui.customviews.editText.material

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import com.deshAndDez.R


class TextMaterialInput(context: Context, attrs: AttributeSet?) :
    BaseMaterialEditText(context, attrs) {
    init {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                typingCallback.onTyping(charSequence.toString())
                if (!charSequence.toString().isNullOrEmpty()) {
                    isValid = true
                    error = ""
                    textInputLayout.error = null
                } else {
                    isValid = false
                    error = context.getString(R.string.required)
                    textInputLayout.error = error
                }
            }
            override fun afterTextChanged(editable: Editable) {
            }
        })
    }

}
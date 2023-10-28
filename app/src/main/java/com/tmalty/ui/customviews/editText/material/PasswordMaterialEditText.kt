package com.tmalty.ui.customviews.editText.material

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import com.tmalty.R


class PasswordMaterialEditText(context: Context, attrs: AttributeSet?) :
    BaseMaterialEditText(context, attrs) {
    init {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                typingCallback.onTyping(charSequence.toString())
                when {
                    charSequence.toString().isNullOrEmpty() -> {
                        isValid = false
                        error = context.getString(R.string.required)
                        textInputLayout.error = error
                    }
                    charSequence.toString().length < 6 -> {
                        isValid = false
                        error = context.getString(R.string.password_length_not_valid)
                        textInputLayout.error = error
                    }
                    else -> {
                        isValid = true
                        error = ""
                        textInputLayout.error = null
                    }
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
    }
}
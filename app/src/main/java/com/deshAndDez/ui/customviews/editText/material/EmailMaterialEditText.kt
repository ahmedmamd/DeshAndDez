package com.deshAndDez.ui.customviews.editText.material

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Patterns
import com.deshAndDez.R


class EmailMaterialEditText(context: Context, attrs: AttributeSet?) :
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
                    isEmailNotValid(charSequence.toString()) -> {
                        isValid = false
                        error = context.getString(R.string.email_not_valid)
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

    fun isEmailNotValid(input: String): Boolean {
        return !Patterns.EMAIL_ADDRESS.matcher(input).matches()
    }
}
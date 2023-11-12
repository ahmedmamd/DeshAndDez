package com.deshAndDez.ui.customviews.editText.normal

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Patterns
import com.deshAndDez.R


class EmailInput(context: Context, attrs: AttributeSet?) : BaseInput(context, attrs) {
    init {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                typingCallback.onTyping(charSequence.toString())
                when {
                    charSequence.toString().isNullOrEmpty() -> {
                        isValid = false
                        error = context.getString(R.string.required)
                    }
                    isEmailNotValid(charSequence.toString()) -> {
                        isValid = false
                        error = context.getString(R.string.email_not_valid)
                    }
                    else -> {
                        isValid = true
                        error = null
                    }
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
    }
    fun isEmailNotValid(input: String): Boolean {
        return !Patterns.EMAIL_ADDRESS.matcher(input).matches()
    }

    override fun setOnTextTyping(typingCallback: TypingCallback) {
        super.setOnTextTyping(typingCallback)
    }


}
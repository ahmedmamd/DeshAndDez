package com.deshAndDez.ui.customviews.editText.material

import android.content.Context
import android.util.AttributeSet
import android.view.animation.CycleInterpolator
import android.view.animation.TranslateAnimation
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.deshAndDez.R


open class BaseMaterialEditText(context: Context, attrs: AttributeSet?) :
    TextInputEditText(context, attrs) {

    var isValid = false
    var error = context.getString(R.string.required)
    var isRequired = false
    lateinit var typingCallback: TypingCallback

    init {
    }

    var textInputLayout = TextInputLayout(context, attrs)
    open fun setOnTextTyping(inputLayout: TextInputLayout, typingCallback: TypingCallback) {
        textInputLayout = inputLayout
        this.typingCallback = typingCallback
    }

    interface TypingCallback {
        fun onTyping(text: String)
    }

    open fun shakeError(): TranslateAnimation? {
        val shake = TranslateAnimation(0F, 10F, 0F, 0F)
        shake.duration = 500
        shake.interpolator = CycleInterpolator(7F)
        return shake
    }
}
package com.deshAndDez.commons.extensions

import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.widget.CheckBox
import androidx.appcompat.widget.AppCompatEditText
import com.deshAndDez.R
import com.deshAndDez.commons.RegexPatternsUtilities

fun AppCompatEditText.isValidEmail(): Boolean {
    val email = this.text.toString().trim()
    if (email.isEmpty()) {
        this.requestFocus()
        error = this.context.getString(R.string.this_field_is_required)
        return false
    }
    if (!RegexPatternsUtilities.emailPattern.matches(email)) {
        this.requestFocus()
        error = this.context.getString(R.string.please_enter_a_valid_email_address)
        return false
    }

    error = null
    return true
}

fun AppCompatEditText.applyPhoneNumberFilters(regexPattern: Regex,maxLength: Int? = null) {
    maxLength?.let {
        filters = arrayOf(android.text.InputFilter.LengthFilter(it))
    }
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val inputText = charSequence.toString()
            if (!inputText.isNullOrEmpty()) {
                if (!regexPattern.matches(inputText)) {
                    setText("")
                }
            }
        }

        override fun afterTextChanged(p0: Editable?) {
        }
    })
}

fun AppCompatEditText.isValid(): Boolean {
    val text = this.text.toString().trim()
    if (text.isEmpty()) {
        this.requestFocus()
        error = this.context.getString(R.string.this_field_is_required)
        return false
    }
    error = null
    return true
}

fun AppCompatEditText.setupPasswordToggleCheckbox(passwordToggleCheckbox: CheckBox) {
    passwordToggleCheckbox.setOnCheckedChangeListener { compoundButton, isChecked ->
        if (compoundButton.isPressed) {
            transformationMethod = if (isChecked) null else PasswordTransformationMethod()
        }

    }
}

fun AppCompatEditText.isValidPassword(confirmPasswordEditText: AppCompatEditText? = null): Boolean {
    val password = this.text.toString().trim()
    if (password.isEmpty()) {
        this.requestFocus()
        error = this.context.getString(R.string.this_field_is_required)
        return false
    }
    if (password.length < 6) {
        this.requestFocus()
        error =
            this.context.getString(R.string.password_must_contain_at_least_x_characters_including_uppercase_lowercase_numeric_and_special_characters)
        return false
    }
    confirmPasswordEditText?.let {
        val confirmPassword = it.text.toString().trim()
        if (confirmPassword.isEmpty()) {
            it.requestFocus()
            it.error = this.context.getString(R.string.this_field_is_required)
            return false
        }
        if (confirmPassword.length < 6) {
            it.requestFocus()
            it.error =
                this.context.getString(R.string.password_must_contain_at_least_x_characters_including_uppercase_lowercase_numeric_and_special_characters)
            return false
        }
        if (password != confirmPassword) {
            it.requestFocus()
            it.error = it.context.getString(R.string.password_matching_not_valid)
            return false
        }
    }
    error = null
    return true
}

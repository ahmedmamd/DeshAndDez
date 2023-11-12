package com.deshAndDez.ui.customviews.numberpicker

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.deshAndDez.R
import com.deshAndDez.databinding.CustomLayoutNumberPickerBinding

class NumberPickerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {


    lateinit var binding: CustomLayoutNumberPickerBinding
    private var maxValue = 1000000
    private var minValue = 1
    private var defaultValue = minValue
    private var currentValue = defaultValue

    init {
        // Inflate the custom view layout
        binding = CustomLayoutNumberPickerBinding.bind(
            LayoutInflater.from(context).inflate(R.layout.custom_layout_number_picker, this, true)
        )
        binding.valueTextview.text = "$defaultValue"
        // Set click listeners for the minus and plus buttons

    }

    private fun updateValueText(value: Int) {
        binding.valueTextview.text = value.toString()
    }

    private fun setDefaultValue(value: Int) {
        defaultValue = value
        currentValue = defaultValue
        updateValueText(defaultValue)
    }

    fun setupNumberPicker(
        min: Int? = null,
        max: Int? = null,
        onValueChanged: (Int) -> Unit
    ) {
        min?.let {
            minValue = it
            setDefaultValue(minValue)
        }
        max?.let {
            maxValue = it
        }
        binding.minus.setOnClickListener {
            if (currentValue > minValue) {
                currentValue -= 1
                updateValueText(currentValue)
                onValueChanged(currentValue)
            }
        }

        binding.plus.setOnClickListener {
            if (currentValue < maxValue) {
                currentValue += 1
                updateValueText(currentValue)
                onValueChanged(currentValue)
            }
        }
    }

    fun getCurrentValue(): Int = currentValue
    fun setCurrentValue(value: Int) {
        currentValue = value
        updateValueText(currentValue)
    }
}
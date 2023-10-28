//package com.tmalty.ui.customviews.custom
//
//import android.content.Context
//import android.view.LayoutInflater
//import com.google.android.material.bottomsheet.BottomSheetDialog
//import com.tmalty.commons.extensions.setUpSheetUi
//import com.tmalty.databinding.SheetLayoutDatePickerBinding
//import java.util.*
//
//class DatePickerSheet(
//    private val mContext: Context,
//    private val isBirthDatePicker: Boolean? = null,
//    private val onConfirm: (Calendar) -> Unit
//) : BottomSheetDialog(mContext) {
//    var binding: SheetLayoutDatePickerBinding =
//        SheetLayoutDatePickerBinding.inflate(LayoutInflater.from(mContext))
//
//    init {
//        setContentView(binding.root)
//        setUpSheetUi(binding.root.parent)
//        setUpActions()
//        if (isBirthDatePicker != null)
//            binding.calendar.maxDate = System.currentTimeMillis()
//    }
//
//    private fun setUpActions() {
//        var calendar = Calendar.getInstance()
//
//        binding.btnConfirm.setOnClickListener {
//            calendar.set(
//                binding.calendar.year,
//                binding.calendar.month,
//                binding.calendar.dayOfMonth
//            )
//            onConfirm(calendar)
//            dismiss()
//        }
//    }
//}
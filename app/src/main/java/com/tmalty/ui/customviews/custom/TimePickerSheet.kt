//package com.tmalty.ui.customviews.custom
//
//import android.content.Context
//import android.view.LayoutInflater
//import com.google.android.material.bottomsheet.BottomSheetDialog
//import com.tmalty.commons.extensions.setUpSheetUi
//import com.tmalty.databinding.SheetLayoutTimePickerBinding
//import java.util.*
//
//class TimePickerSheet(
//    private val mContext: Context,
//    private val onConfirm: (Calendar) -> Unit
//) : BottomSheetDialog(mContext) {
//    var binding: SheetLayoutTimePickerBinding =
//        SheetLayoutTimePickerBinding.inflate(LayoutInflater.from(mContext))
//
//    init {
//        setContentView(binding.root)
//        setUpSheetUi(binding.root.parent)
//        setUpActions()
//    }
//
//    private fun setUpActions() {
//        binding.btnConfirm.setOnClickListener {
//            var calendar = Calendar.getInstance()
//            calendar.set(Calendar.HOUR_OF_DAY, binding.calendar.hour)
//            calendar.set(Calendar.MINUTE, binding.calendar.minute)
//            onConfirm(calendar)
//            dismiss()
//        }
//    }
//}
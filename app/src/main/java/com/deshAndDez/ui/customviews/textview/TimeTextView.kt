//package com.deshAndDez.ui.customviews.textview
//
//import android.content.Context
//import android.util.AttributeSet
//import com.deshAndDez.ui.customviews.custom.TimePickerSheet
//import java.text.DateFormat
//import java.text.ParseException
//import java.text.SimpleDateFormat
//import java.util.*
//
//class TimeTextView(context: Context, attrs: AttributeSet?) :
//    androidx.appcompat.widget.AppCompatTextView(context, attrs) {
//    var apiDateFormat = "yyyy-MM-dd'T'HH:mm:ss"
//    var apiTime = ""
//    var isValid = false
//
//    init {
//        setOnClickListener {
//            TimePickerSheet(context, onConfirm = {
//                setupDates(it.time)
//            }).show()
//        }
//    }
//
//    fun reset() {
//        text = ""
//        apiTime = ""
//        isValid = false
//    }
//
//    private fun setupDates(date: Date) {
//        text = formatUiTime(date)
//        apiTime = formatApiTime(date)
//        isValid = !apiTime.isNullOrEmpty()
//    }
//
//    private fun formatUiTime(date: Date): String {
//        var dateStr = ""
//        try {
//            val formatter: DateFormat = SimpleDateFormat(
//                "hh:mm aa", Locale.ENGLISH
//            ) //If you need time just put specific format for time like 'HH:mm:ss'
//            dateStr = formatter.format(date)
//        } catch (e: ParseException) {
//            e.printStackTrace()
//        }
//        return dateStr
//    }
//
//    fun formatUiDateFromString(dateInput: String): String {
//        var dateStr = ""
//        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
//        var date: Date? = null
//        try {
//            date = dateFormat.parse(dateInput)
//            val formatter: DateFormat = SimpleDateFormat(
//                "hh:mm aa", Locale.ENGLISH
//            ) //If you need time just put specific format for time like 'HH:mm:ss'
//            dateStr = formatter.format(date)
//        } catch (e: ParseException) {
//            e.printStackTrace()
//        }
//        return dateStr
//    }
//
//    private fun formatApiTime(date: Date): String {
//        var dateStr = ""
//        try {
//            val formatter: DateFormat = SimpleDateFormat(
//                "hh:mm aa", Locale.ENGLISH
//            ) //If you need time just put specific format for time like 'HH:mm:ss'
//            dateStr = formatter.format(date)
//        } catch (e: ParseException) {
//            e.printStackTrace()
//        }
//        return dateStr
//    }
//
//    fun formatApiTimeFromString(dateInput: String): String {
//        var dateStr = ""
//        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
//        var date: Date? = null
//        try {
//            date = dateFormat.parse(dateInput)
//            val formatter: DateFormat = SimpleDateFormat(
//                "hh:mm aa", Locale.ENGLISH
//            ) //If you need time just put specific format for time like 'HH:mm:ss'
//            dateStr = formatter.format(date)
//        } catch (e: ParseException) {
//            e.printStackTrace()
//        }
//        return dateStr
//    }
//
//}
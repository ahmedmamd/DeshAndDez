//package com.tmalty.ui.customviews.textview
//
//import android.content.Context
//import android.util.AttributeSet
//import com.tmalty.ui.customviews.custom.DatePickerSheet
//import java.text.DateFormat
//import java.text.ParseException
//import java.text.SimpleDateFormat
//import java.util.*
//
//class DateTextView(context: Context, attrs: AttributeSet?) :
//    androidx.appcompat.widget.AppCompatTextView(context, attrs) {
//    var apiDateFormat = "yyyy-MM-dd'T'HH:mm:ss"
//    var apiDate = ""
//    var apiTime = ""
//    var isValid = false
//
//    init {
//        setOnClickListener {
//            DatePickerSheet(context, onConfirm = {
//                setupDates(it.time)
//            }).show()
//        }
//    }
//
//    fun reset() {
//        text = ""
//        apiDate = ""
//        apiTime = ""
//        isValid = false
//    }
//
//    private fun setupDates(date: Date) {
//        text = formatUiDate(date)
//        apiDate = formatApiDate(date)
//        apiTime = formatApiTime(date)
//        isValid = !apiDate.isNullOrEmpty() && !apiDate.isNullOrEmpty()
//    }
//
//    private fun formatUiDate(date: Date): String {
//        var dateStr = ""
//        try {
//            val formatter: DateFormat = SimpleDateFormat(
//                "dd/MM/yyyy", Locale.ENGLISH
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
//                "dd/MM/yyyy", Locale.ENGLISH
//            ) //If you need time just put specific format for time like 'HH:mm:ss'
//            dateStr = formatter.format(date)
//        } catch (e: ParseException) {
//            e.printStackTrace()
//        }
//        return dateStr
//    }
//
//    private fun formatApiDate(date: Date): String {
//        var dateStr = ""
//        try {
//            val formatter: DateFormat = SimpleDateFormat(
//                apiDateFormat, Locale.ENGLISH
//            ) //If you need time just put specific format for time like 'HH:mm:ss'
//            dateStr = formatter.format(date)
//        } catch (e: ParseException) {
//            e.printStackTrace()
//        }
//        return dateStr
//    }
//
//    fun formatApiDateFromString(dateInput: String): String {
//        var dateStr = ""
//        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
//        var date: Date? = null
//        try {
//            date = dateFormat.parse(dateInput)
//            val formatter: DateFormat = SimpleDateFormat(
//                apiDateFormat, Locale.ENGLISH
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
//                "HH:mm", Locale.ENGLISH
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
//                "HH:mm", Locale.ENGLISH
//            ) //If you need time just put specific format for time like 'HH:mm:ss'
//            dateStr = formatter.format(date)
//        } catch (e: ParseException) {
//            e.printStackTrace()
//        }
//        return dateStr
//    }
//
//}
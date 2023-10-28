package com.tmalty.commons.helpers

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateUtilities {
    companion object {
        fun formatDateFromObjectDate(dateFormat: String, date: Date): String {
            var dateStr = ""
            try {
                val formatter: DateFormat = SimpleDateFormat(
                    "dd/MM/yyyy", Locale.ENGLISH
                ) //If you need time just put specific format for time like 'HH:mm:ss'
                dateStr = formatter.format(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return dateStr
        }

        fun formatDateFromStringDate(
            dateInput: String,
            dateFormat: String?=null,
            serverDataFormat: String? = null
        ): String {
            var dateStr = ""
            var date: Date? = null
            try {
                date = SimpleDateFormat(serverDataFormat ?: "yyyy-MM-dd'T'HH:mm:ss").parse(dateInput)
                val formatter: DateFormat = SimpleDateFormat(
                    dateFormat ?: "dd/MM/yyyy", Locale.ENGLISH
                ) //If you need time just put specific format for time like 'HH:mm:ss'
                dateStr = formatter.format(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return dateStr
        }

        fun formatTimeFromStringDate(
            dateInput: String,
            dateFormat: String?=null,
            serverDataFormat: String? = null
        ): String {
            var dateStr = ""
            var date: Date? = null
            try {
                date = SimpleDateFormat(serverDataFormat ?: "yyyy-MM-dd'T'HH:mm:ss").parse(dateInput)
                val formatter: DateFormat = SimpleDateFormat(
                    dateFormat ?: "hh:mm a  ", Locale.ENGLISH
                ) //If you need time just put specific format for time like 'HH:mm:ss'
                dateStr = formatter.format(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return dateStr
        }
    }
}
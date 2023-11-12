package com.deshAndDez.commons.helpers

import android.content.Context
import com.deshAndDez.R
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class GetTimeAgo {
    /*
     *----THIS CLASS IS FOR GETTING LAST SEEN TIME IN CHATS ----
     * ---IT CONVERTS TIME_STAMP INTO TIME_AGO
     */

    /*
     *----THIS CLASS IS FOR GETTING LAST SEEN TIME IN CHATS ----
     * ---IT CONVERTS TIME_STAMP INTO TIME_AGO
     */
    private val SECOND_MILLIS = 1000
    private val MINUTE_MILLIS = 60 * SECOND_MILLIS
    private val HOUR_MILLIS = 60 * MINUTE_MILLIS
    private val DAY_MILLIS = 24 * HOUR_MILLIS

    fun getTimeAgo(time: Long, ctx: Context): String? {
        var time = time
        if (time < 1000000000000L) {
            // if timestamp given in seconds, convert to millis
            time *= 1000
        }
        //long now = getCurrentTime(ctx);
        val now = System.currentTimeMillis()
        if (time > now || time <= 0) {
            return ctx.resources.getString(R.string.just_now)
        }
        // TODO: localize
        val diff = now - time
        return if (diff < MINUTE_MILLIS) {
            ctx.resources.getString(R.string.just_now)
        } else if (diff < 2 * MINUTE_MILLIS) {
            ctx.resources.getString(R.string.a_min_ago)
        } else if (diff < 50 * MINUTE_MILLIS) {
            (diff / MINUTE_MILLIS).toString() + " " + ctx.resources.getString(R.string.a_min_ago)
        } else if (diff < 90 * MINUTE_MILLIS) {
            ctx.resources.getString(R.string.hour_ago)
        } else if (diff < 24 * HOUR_MILLIS) {
            (diff / HOUR_MILLIS).toString() + " " + ctx.resources.getString(R.string.a_min_ago)
        } else if (diff < 48 * HOUR_MILLIS) {
            ctx.resources.getString(R.string.yesterday)
        } else {
            ""
        }
    }

    fun getTimeInMillies(datef: String?): Long {
        var time: Long = 0
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        var date: Date? = null
        try {
            //formatting the dateString to convert it into a Date
            date = dateFormat.parse(datef)
            val calendar = Calendar.getInstance()
            //Setting the Calendar date and time to the given date and time
            calendar.time = date
            time = calendar.timeInMillis
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return time
    }
}
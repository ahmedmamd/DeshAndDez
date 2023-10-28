package com.tmalty.commons.helpers

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import android.text.Html
import android.text.TextUtils
import android.text.format.DateUtils
import android.view.View
import android.widget.ImageView
import androidx.annotation.NonNull
import com.bumptech.glide.Glide
import com.tmalty.R
import com.tmalty.commons.helpers.Utils.Companion.getDateMilliseconds
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter("notNullText")
fun text(textView: TextView, str: String?) {
    textView.text = if (str == null || str.isEmpty() || str.trim { it <= ' ' }
            .isEmpty() || str === "null") "" else str.replace("\"", "")
}

@BindingAdapter("bindCode")
fun bindCode(textView: TextView, str: String?) {
    textView.text = if (str.isNullOrEmpty() || str.trim { it <= ' ' }
            .isEmpty() || str === "null") "" else "#" + str.replace("\"", "")
}

@BindingAdapter("notNullHtmlText")
fun textHtml(textView: TextView, str: String?) {
    val txt = if (str.isNullOrEmpty() || str.trim { it <= ' ' }
            .isEmpty() || str === "null") "" else str
    textView.text = Html.fromHtml(txt)
}

@BindingAdapter("setVisibleIf")
fun setVisibleIf(view: View, condition: Boolean) {
    if (condition)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter("notificationAsRead")
fun setNotificationAsRead(view : View,isRead : Boolean) {
//    val context = view.context
//    val colorResId = if (isRead) R.color.transparent else R.color.read_notification_bg_color
//    view.setBackgroundColor(context.getColor(colorResId))
}
@BindingAdapter("hideMidTextWithStars")
fun hideMidTextWithStars(textView: TextView, text: String) {
    if (text.length < 3)
        textView.text = ""
    textView.text = text.replaceRange(2, text.length - 3, "*".repeat(text.length - 5))
}

@BindingAdapter("timeAgo")
fun TextView.setTimeAgo(date : String) {
    getDateMilliseconds(date)?.let {
        val currentTime = System.currentTimeMillis()
        val timeDifference = currentTime - it
        val timeAgo = when {
            timeDifference < DateUtils.MINUTE_IN_MILLIS -> {
                DateUtils.getRelativeTimeSpanString(it, currentTime, DateUtils.SECOND_IN_MILLIS)
            }
            timeDifference < DateUtils.HOUR_IN_MILLIS -> {
                DateUtils.getRelativeTimeSpanString(it, currentTime, DateUtils.MINUTE_IN_MILLIS)
            }
            timeDifference < DateUtils.DAY_IN_MILLIS -> {
                DateUtils.getRelativeTimeSpanString(it, currentTime, DateUtils.HOUR_IN_MILLIS)
            }
            else -> {
                val dateFormat = SimpleDateFormat("MMM d, yyyy", Locale.getDefault())
                dateFormat.format(Date(it))
            }
        }
        text = timeAgo
    }
}
@BindingAdapter("bindFullDate")
fun bindFullDate(@NonNull textView: TextView, dateString: String?) {
    var dateStr = ""
    if (dateString != null) {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        var date: Date? =
            null //You will get date object relative to server/client timezone wherever it is parsed
        try {
            //  Sat 10 November 2018
            date = dateFormat.parse(dateString)
            val formatter: DateFormat = SimpleDateFormat(
                "dd MMM HH:mm a",
            ) //If you need time just put specific format for time like 'HH:mm:ss'
            dateStr = formatter.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }
    textView.text = dateStr
}


//@BindingAdapter(value = ["bind:value", "bind:text"], requireAll = false)
//fun formatText(textView: TextView, value: String?, text: String?) {
//    val txt = if (value == null || value.isEmpty() || value.trim { it <= ' ' }
//            .isEmpty() || value === "null") "" else value
//    val outputText = "<b>$value</b>$text"
//    textView.text = Html.fromHtml(outputText)
//}

@BindingAdapter("underlineTextView")
fun underlineTextView(textView: TextView, text: String?) {
    textView.text = text
    textView.paintFlags = textView.paintFlags or Paint.UNDERLINE_TEXT_FLAG
}

@BindingAdapter("oldPriceTextView")
fun setOldPriceTextView(textView: TextView, oldPrice: String?) {
    textView.text = oldPrice
    textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}

@BindingAdapter("bindServerDate")
fun bindServerDate(@NonNull textView: TextView, dateString: String?) {
    var dateStr = ""
    if (dateString != null) {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        var date: Date? =
            null //You will get date object relative to server/client timezone wherever it is parsed
        try {
            //  Sat 10 November 2018
            date = dateFormat.parse(dateString)
            val formatter: DateFormat = SimpleDateFormat(
                "EEE d MMM yyyy",
            ) //If you need time just put specific format for time like 'HH:mm:ss'
            dateStr = formatter.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }
    textView.text = dateStr
}

@BindingAdapter("bindBirthdate")
fun bindBirthdate(@NonNull textView: TextView, dateString: String?) {
    var dateStr = ""
    if (dateString != null) {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        var date: Date? =
            null //You will get date object relative to server/client timezone wherever it is parsed
        try {
            date = dateFormat.parse(dateString)
            val formatter: DateFormat = SimpleDateFormat(
                "dd/MM/yyyy", Locale.ENGLISH
            ) //If you need time just put specific format for time like 'HH:mm:ss'
            dateStr = formatter.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }
    textView.text = dateStr
}

@BindingAdapter("bindLeftTime")
fun bindLeftTime(@NonNull textView: TextView, dateString: String?) {
    var dateStr = ""
    if (dateString != null) {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        var date: Date? =
            null //You will get date object relative to server/client timezone wherever it is parsed
        try {
            date = dateFormat.parse(dateString)
            val formatter: DateFormat = SimpleDateFormat(
                "HH:mm:ss",
            ) //If you need time just put specific format for time like 'HH:mm:ss'
            dateStr = formatter.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }
    textView.text = dateStr
}

@BindingAdapter("bindTime")
fun bindTime(@NonNull textView: TextView, dateString: String?) {
    var dateStr = "00/00/0000"
    if (dateString != null) {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        var date: Date? =
            null //You will get date object relative to server/client timezone wherever it is parsed
        try {
            date = dateFormat.parse(dateString)
            val formatter: DateFormat = SimpleDateFormat(
                "HH:mm aa",
            ) //If you need time just put specific format for time like 'HH:mm:ss'
            dateStr = formatter.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }
    textView.text = dateStr
}

@BindingAdapter("imageBinding")
fun imageBinding(view: ImageView, imageUrl: String?) {
    if (TextUtils.isEmpty(imageUrl)) {
//        view.setImageResource(R.drawable.ic_happy_day_logo)
        return
    }
    Glide.with(view.context)
        .load(prepareImageUrl(imageUrl!!))
//        .placeholder(R.drawable.ic_happy_day_logo)
        .timeout(20000)
        .into(view)
}


@BindingAdapter("imageUserBinding")
fun imageUserBinding(view: ImageView, imageUrl: String?) {
    if (TextUtils.isEmpty(imageUrl)) {
//        view.setImageResource(R.drawable.ic_happy_day_logo)
        return
    }
    Glide.with(view.context)
        .load(prepareImageUrl(imageUrl!!))
        .placeholder(R.drawable.user_image_for_test)
        .timeout(20000)
        .into(view)
}

@BindingAdapter("salonLogoBinding")
fun salonLogoBinding(view: ImageView, imageUrl: String?) {
    if (TextUtils.isEmpty(imageUrl)) {
//        view.setImageResource(R.drawable.ic_happy_day_logo)
        return
    }
    Glide.with(view.context)
        .load(prepareImageUrl(imageUrl!!))
//        .placeholder(R.drawable.ic_happy_day_logo)
        .timeout(20000)
        .into(view)
}

@BindingAdapter("salonDefaultBinding")
fun salonDefaultBinding(view: ImageView, imageUrl: String?) {
    if (TextUtils.isEmpty(imageUrl)) {
//        view.setImageResource(R.drawable.ic_happy_day_logo)
        return
    }
    Glide.with(view.context)
        .load(prepareImageUrl(imageUrl!!))
//        .placeholder(R.drawable.ic_happy_day_logo)
        .timeout(20000)
        .into(view)
}

fun prepareImageUrl(imageUrl: String): String? {
    var url = ""
    url =
        if (imageUrl.contains(Constants.Public.SERVER_BASE_URL) || imageUrl.contains("http://") || imageUrl.contains(
                "https://"
            )
        ) imageUrl else Constants.Public.SERVER_BASE_URL.toString() + imageUrl
    return url
}


@BindingAdapter("strikeThrough")
fun strikeThrough(textView: TextView, strikeThrough: Boolean) {
    if (strikeThrough) {
        textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    } else {
        textView.paintFlags = textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }


}


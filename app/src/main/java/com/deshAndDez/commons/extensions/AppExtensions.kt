package com.deshAndDez.commons.extensions

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
//import com.google.firebase.messaging.FirebaseMessagingService
import com.google.gson.Gson
import com.deshAndDez.R


/**Print log*/
fun Any.showVLog(log: String, tag: String = getClassName()) = Log.v(tag, log)

fun Any.showELog(log: String, tag: String = getClassName()) = Log.e(tag, log)

fun Any.showDLog(log: String, tag: String = getClassName()) = Log.d(tag, log)

fun Any.showILog(log: String, tag: String = getClassName()) = Log.i(tag, log)

fun Any.showWLog(log: String, tag: String = getClassName()) = Log.w(tag, log)

fun Any.toJson(any: Any)= Gson().toJson(any)!!


fun Any.getClassName(): String {
    return this::class.java.simpleName
}

inline fun <reified T> String.parseJson(): T {
    val gson = Gson()
    return gson.fromJson(this, T::class.java)
}

//fun FirebaseMessagingService.pushLocalNotification(title : String,messageBody:String,intent : Intent){
//    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//    val pendingIntent = PendingIntent.getActivity(
//        this, 0, intent,
//        PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
//    )
//    val channelId = this.packageName // Create a notification channel if needed (Android 8.0+)
//    val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
//    val notificationBuilder = NotificationCompat.Builder(this, channelId)
////        .setSmallIcon(R.drawable.fcm_icon) // Replace with your notification icon
//        .setContentTitle(title)
//        .setContentText(messageBody)
//        .setAutoCancel(true)
//        .setStyle(NotificationCompat.DecoratedCustomViewStyle())
//        .setSound(defaultSoundUri)
//        .setGroupSummary(true)
//        .setContentIntent(pendingIntent)
//
//    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//    // Create a notification channel if running on Android 8.0 or higher
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//        val channel = NotificationChannel(
//            channelId,
//            getString(R.string.app_name),
//            NotificationManager.IMPORTANCE_DEFAULT
//        )
//        notificationManager.createNotificationChannel(channel)
//    }
//    // Display the notification
//    notificationManager.notify(0, notificationBuilder.build())
//}
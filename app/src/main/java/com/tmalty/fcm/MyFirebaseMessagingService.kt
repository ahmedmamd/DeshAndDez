package com.tmalty.fcm

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.tmalty.R
import com.tmalty.commons.enums.MyEnums
import com.tmalty.commons.events.EventBus
import com.tmalty.commons.extensions.getClassName
import com.tmalty.commons.extensions.parseJson
import com.tmalty.commons.extensions.pushLocalNotification
import com.tmalty.commons.extensions.showELog
import com.tmalty.commons.extensions.toJson
import com.tmalty.commons.helpers.Constants
import com.tmalty.commons.helpers.Constants.IntentActions.OPEN_MY_TRIP_DETAILS_ACTION
import com.tmalty.data.repositories.settings.SettingsRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyFirebaseMessagingService : FirebaseMessagingService() {

    @Inject
    lateinit var settingsRepository: SettingsRepository
    @Inject
    lateinit var intEventBus: EventBus<Int>
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        settingsRepository.setFirebaseToken(token)
        Log.e(getClassName(), token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        // Check if the message contains data payload
        remoteMessage.data.isNotEmpty().let { notEmpty ->
            if(notEmpty){
                var fcmModel = toJson(remoteMessage.data).parseJson<FcmModel>()
                showELog("${getClassName()} : ${toJson(fcmModel)}")
                handelNotifications(fcmModel)
            }
        }
    }

    //Handel notification model and its click actions
    private fun handelNotifications(fcmModel : FcmModel) {
        var intent = Intent()
        fcmModel.let {
            var title = getString(R.string.app_name)
            var body = it.body.orEmpty()
            var type = it.type.orEmpty()
            var id = it.entityId.orEmpty()
            var unSeenNotificationsCount = it.unSeenNotificationsCount?.or(0)
            when(type){
                MyEnums.FCMActionsTypes.UpdateLocation.value-> {
                    intent.action = OPEN_MY_TRIP_DETAILS_ACTION
                    intent.putExtra(Constants.Intent.TRIP_ID,id)
                }
                MyEnums.FCMActionsTypes.UpdateNotificationBadge.value-> {
                    intEventBus.post(unSeenNotificationsCount?:0)
                }
                MyEnums.FCMActionsTypes.SignOut.value-> {

                }
            }
            pushLocalNotification(title!!,body!!,intent)
        }
    }

}
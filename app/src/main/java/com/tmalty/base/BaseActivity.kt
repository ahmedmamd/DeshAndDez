package com.tmalty.base

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import com.tmalty.commons.events.EventBus
import com.tmalty.commons.helpers.DeviceUtilities
import com.tmalty.commons.helpers.Utils
import com.tmalty.data.repositories.settings.SettingsRepository
import dagger.hilt.android.AndroidEntryPoint
//import www.sanju.motiontoast.MotionToast
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {

//https://www.figma.com/file/mmROXo9EPgN2qrFOeIxBz4/T-malty?type=design&node-id=322-3808&mode=design&t=PgzK3rAg9dR6Xidk-0

    @Inject
    lateinit var settingsRepository: SettingsRepository

    @Inject
    lateinit var intEventBus: EventBus<Int>

    lateinit var myApp: BaseApp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAppLocale()
        myApp = this.applicationContext as BaseApp
        Utils.stopDarkMode()
        settingsRepository.setDeviceId(DeviceUtilities.getDeviceId(this) ?: "")
        handleEvents()
    }

    private fun initAppLocale() {
        if (settingsRepository.getLanguage().isNullOrEmpty()) {
            setLocale(Utils.getCurrentLanguage(this))
        } else {
            setLocale(settingsRepository.getLanguage())
        }
    }

    fun setUpNotification() {
        var notificationManager = NotificationManagerCompat.from(this);
        if (!notificationManager.areNotificationsEnabled()) {
            var intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
            startActivity(intent);
        } else {
            Log.e("permission", "success")
            // App has permission to post notifications
        }
    }

    private fun handleEvents() {
    }

    open fun setLocale(lang: String) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val resources: Resources = resources
        val configuration: Configuration = resources.configuration
        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }

    fun shoMsg(msg: String) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
//        MotionToast.createColorToast(
//            this,
//            "App",
//            msg,
//            type,
//            MotionToast.GRAVITY_BOTTOM,
//            MotionToast.LONG_DURATION, null
//        )
    }


    override fun onDestroy() {
        clearReferences()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        myApp.setCurrentActivity(this)
    }

    //Check if in chat activity
    private fun clearReferences() {
        try {
            val currActivity: Activity = myApp.getCurrentActivity()!!
            if (this == currActivity) myApp.setCurrentActivity(null)
        } catch (ex: NullPointerException) {
        }
    }

    override fun onPause() {
        super.onPause()
        clearReferences()
    }
}
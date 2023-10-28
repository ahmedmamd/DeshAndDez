package com.tmalty.commons.helpers

import android.content.Context
import android.provider.Settings

class DeviceUtilities {
    companion object {
        fun getDeviceId(context: Context): String? {
            return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        }
    }
}
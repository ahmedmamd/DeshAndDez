package com.deshAndDez.commons.helpers

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.telephony.TelephonyManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Connectivity @Inject constructor(@param:ApplicationContext var context: Context) {
    var cm: ConnectivityManager
    var networkCallback: ConnectivityManager.NetworkCallback? = null
    val networkInfo: NetworkInfo?
        get() = cm.activeNetworkInfo
    val isConnected: Boolean
        get() {
            val info = networkInfo
            return info != null && info.isConnected
        }
    val isConnectedWifi: Boolean
        get() {
            val info = networkInfo
            return info != null && info.isConnected && info.type == ConnectivityManager.TYPE_WIFI
        }

    /**
     * Check if there is any connectivity to a mobile network
     *
     * @return
     */
    val isConnectedMobile: Boolean
        get() {
            val info = networkInfo
            return info != null && info.isConnected && info.type == ConnectivityManager.TYPE_MOBILE
        }

    /**
     * Check if there is fast connectivity
     *
     * @return
     */
    val isConnectedFast: Boolean
        get() {
            val info = networkInfo
            return info != null && info.isConnected && isConnectionFast(info.type, info.subtype)
        }

    /**
     * Check if the connection is fast
     *
     * @param type
     * @param subType
     * @return
     */
    fun isConnectionFast(type: Int, subType: Int): Boolean {
        return if (type == ConnectivityManager.TYPE_WIFI) {
            true
        } else if (type == ConnectivityManager.TYPE_MOBILE) {
            when (subType) {
                TelephonyManager.NETWORK_TYPE_1xRTT -> false // ~ 50-100 kbps
                TelephonyManager.NETWORK_TYPE_CDMA -> false // ~ 14-64 kbps
                TelephonyManager.NETWORK_TYPE_EDGE -> false // ~ 50-100 kbps
                TelephonyManager.NETWORK_TYPE_EVDO_0 -> true // ~ 400-1000 kbps
                TelephonyManager.NETWORK_TYPE_EVDO_A -> true // ~ 600-1400 kbps
                TelephonyManager.NETWORK_TYPE_GPRS -> false // ~ 100 kbps
                TelephonyManager.NETWORK_TYPE_HSDPA -> true // ~ 2-14 Mbps
                TelephonyManager.NETWORK_TYPE_HSPA -> true // ~ 700-1700 kbps
                TelephonyManager.NETWORK_TYPE_HSUPA -> true // ~ 1-23 Mbps
                TelephonyManager.NETWORK_TYPE_UMTS -> true // ~ 400-7000 kbps
                TelephonyManager.NETWORK_TYPE_EHRPD -> true // ~ 1-2 Mbps
                TelephonyManager.NETWORK_TYPE_EVDO_B -> true // ~ 5 Mbps
                TelephonyManager.NETWORK_TYPE_HSPAP -> true // ~ 10-20 Mbps
                TelephonyManager.NETWORK_TYPE_IDEN -> false // ~25 kbps
                TelephonyManager.NETWORK_TYPE_LTE -> true // ~ 10+ Mbps
                TelephonyManager.NETWORK_TYPE_UNKNOWN -> false
                else -> false
            }
        } else {
            false
        }
    }//2G Data

    //3G Data
    //4G Data
    //5G Data
    //Unknown
    // not connected
    //Wifi
    val networkConnectionType: String
        get() {
            val info = cm.activeNetworkInfo
            if (info == null || !info.isConnected) return "0" // not connected
            if (info.type == ConnectivityManager.TYPE_WIFI) return "1" //Wifi
            if (info.type == ConnectivityManager.TYPE_MOBILE) {
                val networkType = info.subtype
                return when (networkType) {
                    TelephonyManager.NETWORK_TYPE_GPRS, TelephonyManager.NETWORK_TYPE_EDGE, TelephonyManager.NETWORK_TYPE_CDMA, TelephonyManager.NETWORK_TYPE_1xRTT, TelephonyManager.NETWORK_TYPE_IDEN, TelephonyManager.NETWORK_TYPE_GSM -> "3" //2G Data
                    TelephonyManager.NETWORK_TYPE_UMTS, TelephonyManager.NETWORK_TYPE_EVDO_0, TelephonyManager.NETWORK_TYPE_EVDO_A, TelephonyManager.NETWORK_TYPE_HSDPA, TelephonyManager.NETWORK_TYPE_HSUPA, TelephonyManager.NETWORK_TYPE_HSPA, TelephonyManager.NETWORK_TYPE_EVDO_B, TelephonyManager.NETWORK_TYPE_EHRPD, TelephonyManager.NETWORK_TYPE_HSPAP, TelephonyManager.NETWORK_TYPE_TD_SCDMA -> "4" //3G Data
                    TelephonyManager.NETWORK_TYPE_LTE, TelephonyManager.NETWORK_TYPE_IWLAN, 19 -> "5" //4G Data
                    TelephonyManager.NETWORK_TYPE_NR -> "6" //5G Data
                    else -> "0" //Unknown
                }
            }
            return "?"
        }

    init {
        cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}
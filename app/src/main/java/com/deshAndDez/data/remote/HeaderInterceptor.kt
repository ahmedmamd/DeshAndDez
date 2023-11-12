package com.deshAndDez.data.remote

import android.os.Build
import com.deshAndDez.BuildConfig
import com.deshAndDez.commons.helpers.Connectivity
import com.deshAndDez.data.preference.SharedPreferencesManager
import com.deshAndDez.data.repositories.settings.SettingsRepository
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.jetbrains.annotations.NotNull
import java.io.IOException
import javax.inject.Inject

class HeaderInterceptor : Interceptor {
    @Inject
    constructor()

    @Inject
    lateinit var connectivity: Connectivity

    @Inject
    lateinit var settingsRepository: SettingsRepository

    val ANDROID = "0"

    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager

    @NotNull
    @Throws(IOException::class)
    override fun intercept(@NotNull chain: Interceptor.Chain): Response {
        return addRequestHeaders(chain)
    }

    private fun addRequestHeaders(chain: Interceptor.Chain): Response {
        val origin = chain.request()
        val originalHttpUrl = origin.url
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("culture", settingsRepository.getLanguageCode())
            .addQueryParameter("ui-culture", settingsRepository.getLanguage())
            .build()
        var request: Request? = null
        var builder: Request.Builder? = null
        builder = chain.request().newBuilder()
            .url(url)
            .addHeader("AcceptLanguage", settingsRepository.getLanguageCode())
            .addHeader("RegistrationToken", settingsRepository.getFirebaseToken())
            .addHeader("FirebaseToken", settingsRepository.getFirebaseToken())
            .addHeader("OSVersion", Build.VERSION.RELEASE.toString())
            .addHeader("ConnectionType", connectivity.networkConnectionType)
            .addHeader("AppVersion", BuildConfig.VERSION_NAME)
            .addHeader("MachineType", Build.BRAND + " " + Build.MODEL)
            .addHeader("OSType", ANDROID)
            .addHeader("MachineId", settingsRepository.getDeviceId())
            .addHeader("Latitude", "0")
            .addHeader("Longitude", "0")
            .addHeader("Accept", "application/json")
        try {
            if (settingsRepository.getUserAccessToken().isNotEmpty()) {
                builder.addHeader(
                    "Authorization",
                    "Bearer " + settingsRepository.getUserAccessToken()
                )
            }
            request = builder.build()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return chain.proceed(request!!)
    }


    private fun internalServerError(response: Response): Boolean {
        //500 internal server error
        return (response.code == 500)
    }

    private fun shouldLogout(response: Response): Boolean {
        // 401 and auth token means that we need to logout
        return (response.code == 401)
    }
}
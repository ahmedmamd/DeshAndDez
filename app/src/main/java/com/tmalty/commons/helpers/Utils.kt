package com.tmalty.commons.helpers

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.tmalty.R
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class Utils {


    companion object {
        // parse error body
//        fun parseResponse(response: Response<Any>): BaseErrorModel? {
//            var errorMessage = BaseErrorModel(0, "", "")
//            var errorModel: ErrorBody
//            try {
//                val jsonObject = JSONObject(response.errorBody()!!.string())
//                val errorObject: JSONObject = jsonObject.getJSONObject("error")
//                if (errorObject != null) {
//                    errorModel =
//                        Gson().fromJson(errorObject.toString(), ErrorBody::class.java)
//                } else {
//                    errorModel = ErrorBody("Error in api response!")
//                }
//                errorMessage.message = errorModel.message
//                errorMessage.details = errorModel.details
//                errorMessage.code = errorModel.code
//            } catch (e: JSONException) {
//                e.printStackTrace()
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//            return errorMessage
//        }

        //Get Device Id


//        fun executeIfUserLogin(
//            context: Context,
//            sessionHelper: SessionHelper,
//            onExecute: () -> Unit,
//            onCancel: () -> Unit
//        ) {
//            if (!sessionHelper.isLogin) {
////                LoginDialog(context, onYesBtnClick = {
////                    context.startActivity(Intent(context, LoginByEmailActivity::class.java))
////                    (context as Activity).finishAffinity()
////                }, onNoBtnClick = {
////                    onCancel()
////                }).show()
//            } else {
//                onExecute()
//            }
//        }

        fun executeDelay(milliseconds: Long, onExecute: () -> Unit) {
            Handler().postDelayed({
                onExecute()
            }, milliseconds)
        }

        //ColorTintList
        fun getColorTintList(context: Context, color: Int): ColorStateList? {
            return ColorStateList.valueOf(context.resources.getColor(color))
        }

        //setTextViewDrawable
        fun setTextViewDrawable(textView: TextView, start: Int, end: Int) {
            textView.compoundDrawables[0]
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(start, 0, end, 0)
        }
        //stopDarkMode
        fun stopDarkMode() {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        fun dialPhoneNumber(context: Context, phoneNumber: String) {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            context.startActivity(intent)
        }


        fun getDateMilliseconds(datef: String): Long {
            var milliseconds: Long = 0
            val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            var date: Date? = null
            //You will get date object relative to server/client timezone wherever it is parsed
            try {
                date = dateFormat.parse(datef)
                milliseconds = date.time
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return milliseconds
        }
        fun getCurrentLanguage(context: Context): String {
            val locale: Locale

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                locale = context.resources.configuration.locales.get(0)
            } else {
                @Suppress("DEPRECATION")
                locale = context.resources.configuration.locale
            }

            return locale.language
        }
        fun shareAppLink(context: Context) {
            val appPackageName = context.packageName
            val playStoreLink = "https://play.google.com/store/apps/details?id=$appPackageName"

            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Check out Wassal App On Google Play Store: $playStoreLink"
            )
            sendIntent.type = "text/plain"

            val shareIntent = Intent.createChooser(sendIntent, context.getString(R.string.share_via))
            context.startActivity(shareIntent)
        }
    }

}
package com.deshAndDez.commons.extensions

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
//import com.google.android.gms.location.LocationCallback
//import com.google.android.gms.location.LocationRequest
//import com.google.android.gms.location.LocationResult
//import com.google.android.gms.location.LocationServices
import com.deshAndDez.R
import com.deshAndDez.base.BaseViewModel
import com.deshAndDez.commons.helpers.Constants
import com.deshAndDez.data.models.NetworkState
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import www.sanju.motiontoast.MotionToast


fun FragmentActivity.handleResultSharedFlow(
    userFlow: SharedFlow<NetworkState>,
    onShowProgress: (() -> Unit)? = null,
    onHideProgress: (() -> Unit)? = null,
    onSuccess: (data: Any) -> Unit,
    onError: ((th: Throwable) -> Unit)? = null
) {
    this.lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            userFlow.collect { networkState ->
                when (networkState) {
                    is NetworkState.Success<*> -> {
                        onSuccess(networkState.data!!)
                    }

                    is NetworkState.Loading -> {
                        if (onShowProgress != null)
                            onShowProgress()
                        else {
                        }
                    }

                    is NetworkState.StopLoading -> {
                        if (onHideProgress != null)
                            onHideProgress()
                        else {
                        }
                    }

                    is NetworkState.Error -> {
                        if (onError == null) handleErrorGeneral(networkState.throwable) else
                            onError(networkState.throwable)
                    }

                    else -> {}
                }
            }
        }
    }
}

fun <T> FragmentActivity.startActivity(_class: Class<T>) {
    startActivity(Intent(this, _class))
}

fun FragmentActivity.handleErrorGeneral(
    th: Throwable,
    func: (() -> Unit)? = null
): Constants.CustomErrorThrow? {
    //Log.e("error",th.message.toString())
    th.printStackTrace()
    th.message?.let { errorMessage ->
        Log.e(TAG, "errorMessage: $errorMessage")
        val responseErrorResult = errorMessage.convertToResponseErrorResult()
        when (responseErrorResult.code) {
            Constants.HttpRequestErrorCode.SERVER_ERROR -> {
                showMessage(
                    "${responseErrorResult.errorBody?.title}: ${responseErrorResult.errorBody?.details}",
                    MotionToast.TOAST_ERROR
                )
            }

            Constants.HttpRequestErrorCode.UN_AUTHORIZED -> {
                // todo here nave to login screen
//                startActivity(AuthenticationActivity::class.java)
//                finishAffinity()
            }

            Constants.HttpRequestErrorCode.NOT_FOUND -> {
                showMessage(
                    "${responseErrorResult.errorBody?.title}: ${responseErrorResult.errorBody?.details}",
                    MotionToast.TOAST_ERROR
                )
            }

            Constants.HttpRequestErrorCode.INVALID_INPUT -> {
                showMessage(
                    "${responseErrorResult.errorBody?.title}: ${responseErrorResult.errorBody?.details}",
                    MotionToast.TOAST_ERROR
                )
            }

            Constants.HttpRequestErrorCode.PERMISSION_DENIED -> {
                showMessage(
                    "${responseErrorResult.errorBody?.title}: ${responseErrorResult.errorBody?.details}",
                    MotionToast.TOAST_ERROR
                )
            }

            Constants.HttpRequestErrorCode.CONNECTION_ERROR -> {
                showMessage(
                    "${responseErrorResult.errorBody?.title}: ${responseErrorResult.errorBody?.details}",
                    MotionToast.TOAST_ERROR
                )
            }

            else -> {
                //ErrorDialog.show(this, getString(R.string.some_error))
                if (th.cause is Constants.CustomErrorThrow) {
                    val cause = th.cause as Constants.CustomErrorThrow
                    return cause

                } else if (th.message != null) {
                    Log.d(TAG, "handleErrorGeneral: ${th.message}")
                } else
                    th.printStackTrace()
            }
        }
    }
    return null
}

fun FragmentActivity.setupConnectionErrorFlow(baseViewModel: BaseViewModel) {
    lifecycleScope.launchWhenStarted {
        repeatOnLifecycle(Lifecycle.State.CREATED) {
            baseViewModel.connectionErrorFlow.collectLatest {
//                    if (it) NoInternetDialog.show(this@BaseActivity, {})
            }
        }
    }
}


fun FragmentActivity.showMessage(msg: String, type: String) {
    MotionToast.createColorToast(
        this,
        this.getString(R.string.app_name),
        msg,
        type,
        MotionToast.GRAVITY_BOTTOM,
        MotionToast.LONG_DURATION, null
    )
}


fun FragmentActivity.showSuccessMessage(msg: String) {
    MotionToast.createColorToast(
        this,
        this.getString(R.string.app_name),
        msg,
        MotionToast.TOAST_SUCCESS,
        MotionToast.GRAVITY_BOTTOM,
        MotionToast.LONG_DURATION, null
    )
}

fun FragmentActivity.emptyListChecker(list: List<*>, view: TextView) {
    if (list.isNullOrEmpty()) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

fun FragmentActivity.showErrorMessage(msg: String) {
    MotionToast.createColorToast(
        this,
        this.getString(R.string.app_name),
        msg,
        MotionToast.TOAST_ERROR,
        MotionToast.GRAVITY_BOTTOM,
        MotionToast.LONG_DURATION, null
    )
}

fun Activity.showConfirmationDialog(
    title: String,
    message: String,
    positiveBtnTxt: String,
    negativeBtnTxt: String,
    onConfirm: (Boolean) -> Unit
) {

//    var confirmationDialog =
//        ConfirmationDialog(this, title, message, positiveBtnTxt, negativeBtnTxt, onConfirm)
//    confirmationDialog.show()
}


fun Activity.showLoginDialog() {
    // todo here show confirm dialog
//    var confirmationDialog = ConfirmationDialog(this,
//        getString(R.string.app_name),
//        getString(R.string.session_expire),
//        getString(R.string.login),
//        getString(R.string.no_thanks),
//        onConfirm = {
//            startActivity(Intent(this, AuthenticationActivity::class.java))
//        })
//    confirmationDialog.show()
}


fun FragmentActivity.checkLocationPermission(): Boolean {
    if (ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        // Request location permission
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            Constants.Public.LOCATION_PERMISSION_REQUEST_CODE
        )
        return false
    }
    return true
}

// Extension function to check if GPS is enabled
fun FragmentActivity.isGpsEnabled(): Boolean {
    val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
    return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
}

// Extension function to request the user to enable GPS
fun FragmentActivity.requestGpsEnable(requestCode: Int) {
    val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
    startActivityForResult(intent, requestCode)
}

// Extension function to get current location
fun FragmentActivity.getMyLocation(
    successCallback: (location: Location) -> Unit,
    failureCallback: () -> Unit
) {
//    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//    val locationRequest = LocationRequest.create()
//        .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
//
//    if (ActivityCompat.checkSelfPermission(
//            this,
//            Manifest.permission.ACCESS_FINE_LOCATION
//        ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//            this,
//            Manifest.permission.ACCESS_COARSE_LOCATION
//        ) != PackageManager.PERMISSION_GRANTED
//    ) {
//        return
//    }
//    fusedLocationClient.requestLocationUpdates(
//        locationRequest,
//        object : LocationCallback() {
//            override fun onLocationResult(locationResult: LocationResult) {
//                locationResult?.lastLocation?.let { location ->
//                    if (location != null)
//                        successCallback(location)
//                    else
//                        failureCallback
//                }
//            }
//        },
//        Looper.getMainLooper()
//    )
}
package com.deshAndDez.commons.extensions

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.deshAndDez.base.BaseViewModel
import com.deshAndDez.commons.helpers.Constants
import com.deshAndDez.commons.helpers.Constants.Public.CAMERA_PERMISSION_REQUEST_CODE
import com.deshAndDez.data.models.NetworkState
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


fun Fragment.handleResultSharedFlow(
    userFlow: SharedFlow<NetworkState>,
    onShowProgress: (() -> Unit)? = null,
    onHideProgress: (() -> Unit)? = null,
    onSuccess: (data: Any) -> Unit,
    onError: ((th: Throwable) -> Unit)? = null
) {
    this.lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            requireActivity().handleResultSharedFlow(
                userFlow,
                onShowProgress,
                onHideProgress,
                onSuccess,
                onError
            )
        }
    }
}

fun <T> Fragment.startActivity(_class: Class<T>) {
    startActivity(Intent(requireActivity(), _class))
}

fun Fragment.handleErrorGeneral(
    th: Throwable,
    func: (() -> Unit)? = null
): Constants.CustomErrorThrow? {
    th.printStackTrace()
    return requireActivity().handleErrorGeneral(th, func)
}

fun Fragment.setupConnectionErrorFlow(baseViewModel: BaseViewModel) {
    lifecycleScope.launchWhenStarted {
        repeatOnLifecycle(Lifecycle.State.CREATED) {
            baseViewModel.connectionErrorFlow.collectLatest {
//                    if (it) NoInternetDialog.show(this@BaseActivity, {})
            }
        }
    }
}


fun Fragment.showSuccessMessage(msg: String) {
    requireActivity().showSuccessMessage(msg)
}

fun Fragment.emptyListChecker(list: List<*>, view: TextView) {
    requireActivity().emptyListChecker(list, view)
}

fun Fragment.showErrorMessage(msg: String) {
    requireActivity().showErrorMessage(msg)
}

fun Fragment.showConfirmationDialog(
    title: String,
    message: String,
    positiveBtnTxt: String,
    negativeBtnTxt: String,
    onConfirm: (Boolean) -> Unit
) {
    requireActivity().showConfirmationDialog(
        title,
        message,
        positiveBtnTxt,
        negativeBtnTxt,
        onConfirm
    )
}

fun Fragment.showLoginDialog() {
    requireActivity().showLoginDialog()
}


fun Fragment.checkLocationPermission(): Boolean {
    return requireActivity().checkLocationPermission()
}

// Extension function to check if GPS is enabled
fun Fragment.isGpsEnabled(): Boolean {
    return requireActivity().isGpsEnabled()
}

// Extension function to request the user to enable GPS
fun Fragment.requestGpsEnable(requestCode: Int) {
    requireActivity().requestGpsEnable(requestCode)
}

// Extension function to get current location
fun Fragment.getMyLocation(
    successCallback: (location: Location) -> Unit,
    failureCallback: () -> Unit
) {
    requireActivity().getMyLocation(successCallback, failureCallback)
}

fun Fragment.checkGalleryPermission(): Boolean {
    val permission = Manifest.permission.CAMERA
    val granted = PackageManager.PERMISSION_GRANTED
    return ContextCompat.checkSelfPermission(requireContext(), permission) == granted
}

fun Fragment.requestGalleryPermission() {
    requestPermissions(
        arrayOf(Manifest.permission.CAMERA),
        CAMERA_PERMISSION_REQUEST_CODE
    )
}
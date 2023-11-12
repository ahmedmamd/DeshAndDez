package com.deshAndDez.commons.helpers

import android.app.Activity
import android.content.Context
import android.net.Uri
import com.github.dhaval2404.imagepicker.ImagePicker
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

//allprojects {
//    repositories {
//        ...
//        maven { url 'https://jitpack.io' }
//    }
//}
// imagePicker
//    implementation 'com.github.dhaval2404:imagepicker:2.1'
class CameraGalleryHelper {

    companion object {
        fun openCamera(context: Context) {
            ImagePicker.with(context as Activity)
                .cameraOnly()
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                )    //Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }

        fun openGallery(context: Context) {
            ImagePicker.with(context as Activity)
                .galleryOnly()
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                )    //Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }

        fun getImageSelectionMultipart(context: Context, uri: Uri): MultipartBody.Part {
            var selectedFilePath = ImageUtil.getPath(context, uri)
            val file = File(selectedFilePath)
            return MultipartBody.Part.createFormData(
                "File",
                file.name,
                RequestBody.create("image*//*".toMediaTypeOrNull(), file)
            )
        }

    }

}
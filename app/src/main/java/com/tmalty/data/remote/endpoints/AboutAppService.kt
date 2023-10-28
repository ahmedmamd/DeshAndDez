package com.tmalty.data.remote.endpoints

import com.tmalty.data.remote.EndPointResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AboutAppService {
    @GET("api/services/app/Setting/GetByKey")
    suspend fun getAppInfo(@Query("key") skip: String): Response<EndPointResult<String>>
//    @GET("api/services/app/Setting/GetContactInfo")
//    suspend fun getContactInfo(): Response<EndPointResult<ContactInfo>>
}
package com.deshAndDez.data.remote.endpoints

import com.deshAndDez.commons.helpers.Constants
import com.deshAndDez.data.models.notification.Notification
import com.deshAndDez.data.models.notification.NotificationUpdateResponse
import com.deshAndDez.data.remote.EndPointResult
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface NotificationService {
    @GET("api/services/app/SystemNotification/GetMyNotifications")
    suspend fun callNotificationsList(
        @Query(Constants.ApiMappingKey.SKIP) skip: Int,
        @Query(Constants.ApiMappingKey.TAKE) take: Int,
    ): Response<EndPointResult<List<Notification>>>
    //Read notification
    @POST("api/services/app/SystemNotification/SetNotificationAsRead")
    suspend fun callReadNotification(@Body id: Any): Response<EndPointResult<NotificationUpdateResponse>>

    //Read all notifications
    @POST("api/services/app/SystemNotification/SetAllNotificationsAsRead")
    suspend fun callReadAllNotifications(): Response<EndPointResult<NotificationUpdateResponse>>

    //Delete notification
    @POST("api/services/app/SystemNotification/DeleteUserNotification")
    suspend fun callDeleteNotification(@Body id: Any): Response<EndPointResult<NotificationUpdateResponse>>

    //Delete all notifications
    @POST("api/services/app/SystemNotification/DeleteAllMyNotifications")
    suspend fun callDeleteAllNotifications(): Response<EndPointResult<NotificationUpdateResponse>>

    //Mark all as read
    @POST("api/services/app/SystemNotification/SetAllNotificationsAsRead")
    suspend fun markAllAsRead() : Response<EndPointResult<String>>

}
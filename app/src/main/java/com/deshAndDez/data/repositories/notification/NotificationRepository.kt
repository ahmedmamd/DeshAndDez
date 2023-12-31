package com.deshAndDez.data.repositories.notification

import com.deshAndDez.data.models.notification.Notification
import com.deshAndDez.data.models.notification.NotificationUpdateResponse
import kotlinx.coroutines.flow.Flow

interface NotificationRepository {
    suspend fun callNotificationsList(
        skip: Int,
        take: Int
    ): Flow<List<Notification>>

    suspend fun markAllAsRead(): Flow<String>

    suspend fun readNotification(body: Any): Flow<NotificationUpdateResponse>

    suspend fun readAllNotifications(): Flow<NotificationUpdateResponse>

    suspend fun deleteNotification(body: Any): Flow<NotificationUpdateResponse>

    suspend fun deleteAllNotifications(): Flow<NotificationUpdateResponse>

}
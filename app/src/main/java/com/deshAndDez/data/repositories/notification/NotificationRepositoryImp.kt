package com.deshAndDez.data.repositories.notification

import com.deshAndDez.commons.extensions.transformResponseData
import com.deshAndDez.data.remote.endpoints.NotificationService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NotificationRepositoryImp @Inject constructor(private val notificationService: NotificationService) :
    NotificationRepository {
    override suspend fun callNotificationsList(
        skip: Int,
        take: Int
    ) = flow { emit(notificationService.callNotificationsList(skip, take)) }.transformResponseData {
        emit(it)
    }.flowOn(Dispatchers.IO)


    override suspend fun readNotification(body: Any) =
        flow { emit(notificationService.callReadNotification(body)) }.flowOn(Dispatchers.IO)
            .transformResponseData { emit(it) }


    override suspend fun readAllNotifications() =
        flow { emit(notificationService.callReadAllNotifications()) }.transformResponseData {
            emit(
                it
            )
        }.flowOn(Dispatchers.IO)


    override suspend fun deleteNotification(body: Any) =
        flow { emit(notificationService.callDeleteNotification(body)) }.transformResponseData {
            emit(
                it
            )
        }.flowOn(Dispatchers.IO)


    override suspend fun deleteAllNotifications() =
        flow { emit(notificationService.callDeleteAllNotifications()) }.transformResponseData {
            emit(
                it
            )
        }.flowOn(Dispatchers.IO)
    override suspend fun markAllAsRead() = flow {
        emit(notificationService.markAllAsRead())
    }.transformResponseData {
        emit(it)
    }

}
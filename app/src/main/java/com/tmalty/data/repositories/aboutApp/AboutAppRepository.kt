package com.tmalty.data.repositories.aboutApp

import kotlinx.coroutines.flow.Flow

interface AboutAppRepository {
    suspend fun getAboutAppByKey(key : String): Flow<String>
}
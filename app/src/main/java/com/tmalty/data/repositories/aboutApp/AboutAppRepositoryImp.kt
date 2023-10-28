package com.tmalty.data.repositories.aboutApp

import com.tmalty.commons.extensions.transformResponseData
import com.tmalty.data.remote.endpoints.AboutAppService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AboutAppRepositoryImp @Inject constructor
    (private val aboutAppService: AboutAppService) : AboutAppRepository {
    override suspend fun getAboutAppByKey(key: String) = flow {
        emit(aboutAppService.getAppInfo(key))
    }.transformResponseData { emit(it) }

}
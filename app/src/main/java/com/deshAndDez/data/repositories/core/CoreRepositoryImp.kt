package com.deshAndDez.data.repositories.core

import com.deshAndDez.data.remote.endpoints.CoreService
import javax.inject.Inject

class CoreRepositoryImp @Inject constructor(
    private val coreService: CoreService,
) : CoreRepository {
}
package com.tmalty.data.repositories.core

import com.tmalty.data.remote.endpoints.CoreService
import javax.inject.Inject

class CoreRepositoryImp @Inject constructor(
    private val coreService: CoreService,
) : CoreRepository {
}
package com.deshAndDez.ui.main.activities

import com.deshAndDez.base.BaseViewModel
import com.deshAndDez.data.models.NetworkState
import com.deshAndDez.data.repositories.account.AccountRepository
import com.deshAndDez.data.repositories.core.CoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val coreRepository: CoreRepository,private val accountRepository: AccountRepository) : BaseViewModel() {

    private val _locationsFlow = MutableSharedFlow<NetworkState>()

    val locationsFlow get() = _locationsFlow.asSharedFlow()

    fun isUserLogin() = accountRepository.isUserLogin()
}
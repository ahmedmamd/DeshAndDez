package com.tmalty.ui.auth.login

import androidx.lifecycle.viewModelScope
import com.tmalty.base.BaseViewModel
import com.tmalty.data.models.NetworkState
import com.tmalty.data.repositories.account.AccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(private val accountRepository: AccountRepository) :
    BaseViewModel() {


    private val _loginFlow = MutableSharedFlow<NetworkState>()

    val loginFlow get() = _loginFlow.asSharedFlow()

    private val _profileFlow = MutableSharedFlow<NetworkState>()
    val profileFlow get() = _profileFlow.asSharedFlow()

    private val _joinFlow = MutableSharedFlow<NetworkState>()
    val joinFlow get() = _joinFlow.asSharedFlow()

    fun join(
        firstName: String,
        lastName: String,
        companyName: String,
        email: String,
        phone: String
    ) {

        viewModelScope.launch {
            val joinFlowRequest = accountRepository.sendJoiningRequest(firstName, lastName, companyName, email, phone)
            executeSharedFlow(_joinFlow, joinFlowRequest)
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch() {
            val loginFlowRequest = accountRepository.login(email, password)
            executeSharedFlow(_loginFlow, loginFlowRequest, onCollectSuccess = {
                callProfile()
            })
        }
    }

    fun cleanUserSessionIfAccessTokenFound() {
        viewModelScope.launch {
            if (accountRepository.isUserLogin())
                accountRepository.logout()
        }
    }

    private fun callProfile() {
        viewModelScope.launch {
            val profileFlowRequest = accountRepository.callMyProfile()
            executeSharedFlow(_profileFlow, profileFlowRequest)
        }
    }
}
package com.tmalty.ui.splash

import androidx.lifecycle.viewModelScope
import com.tmalty.base.BaseViewModel
import com.tmalty.commons.helpers.Constants
import com.tmalty.data.repositories.account.AccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val accountRepository: AccountRepository
) : BaseViewModel() {

    private val _uiSuccessState = MutableStateFlow<SplashUiState>(SplashUiState.Initial)
    val uiSuccessState: StateFlow<SplashUiState> get() = _uiSuccessState.asStateFlow()
    fun startSplashTimer() {
        viewModelScope.launch {
            delay(Constants.Public.SPLASH_DISPLAY_LENGTH)
            if (accountRepository.isUserLogin()) {
                _uiSuccessState.value =
                    SplashUiState.AuthenticatedUserState
            } else {
                _uiSuccessState.value =
                    SplashUiState.UnAuthenticatedUserState
            }
        }
    }
}
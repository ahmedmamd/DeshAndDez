package com.deshAndDez.ui.splash

sealed class SplashUiState {
    object Initial : SplashUiState()
    object AuthenticatedUserState :
        SplashUiState()
    object UnAuthenticatedUserState :
        SplashUiState()
}

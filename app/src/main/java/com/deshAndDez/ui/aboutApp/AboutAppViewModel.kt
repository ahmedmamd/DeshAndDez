package com.deshAndDez.ui.aboutApp

import androidx.lifecycle.viewModelScope
import com.deshAndDez.base.BaseViewModel
import com.deshAndDez.data.models.NetworkState
import com.deshAndDez.data.repositories.aboutApp.AboutAppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AboutAppViewModel @Inject constructor(private var aboutAppRepository: AboutAppRepository) : BaseViewModel() {
    private val _aboutApp = MutableSharedFlow<NetworkState>()
    val aboutAppFlow get() = _aboutApp

    private val _contactApp = MutableSharedFlow<NetworkState>()
    val contactAppFlow get() = _contactApp

    fun callAboutAppByKey(key : String){
        viewModelScope.launch {
            var aboutAppRequest = aboutAppRepository.getAboutAppByKey(key)
            executeSharedFlow(aboutAppFlow,aboutAppRequest)
        }
    }

    fun getContactInfo(){
        viewModelScope.launch {
//            var contactInfoRequest = aboutAppRepository.getContactUsInfo()
//            executeSharedFlow(contactAppFlow,contactInfoRequest)
        }
    }
}
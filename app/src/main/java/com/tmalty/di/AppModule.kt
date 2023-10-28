package com.tmalty.di

import com.tmalty.data.remote.firebase.FirebaseService
import com.tmalty.data.remote.firebase.FirebaseServiceImp
import com.tmalty.data.repositories.aboutApp.AboutAppRepository
import com.tmalty.data.repositories.aboutApp.AboutAppRepositoryImp
import com.tmalty.data.repositories.account.AccountRepository
import com.tmalty.data.repositories.account.AccountRepositoryImp
import com.tmalty.data.repositories.core.CoreRepository
import com.tmalty.data.repositories.core.CoreRepositoryImp
import com.tmalty.data.repositories.notification.NotificationRepository
import com.tmalty.data.repositories.notification.NotificationRepositoryImp
import com.tmalty.data.repositories.settings.SettingsRepository
import com.tmalty.data.repositories.settings.SettingsRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideAccountRepository(accountRepositoryImp: AccountRepositoryImp): AccountRepository

    @Binds
    abstract fun provideNotificationRepository(notificationRepositoryImp: NotificationRepositoryImp): NotificationRepository

    @Binds
    abstract fun provideSettingsRepository(settingsRepositoryImp: SettingsRepositoryImp): SettingsRepository
    @Binds
    abstract fun provideCoreRepository(coreRepositoryImp: CoreRepositoryImp): CoreRepository
    @Binds
    abstract fun provideFirebaseService(firebaseServiceImp: FirebaseServiceImp): FirebaseService
    @Binds
    abstract fun provideAboutAppRepository(aboutAppRepositoryImp: AboutAppRepositoryImp) : AboutAppRepository


}
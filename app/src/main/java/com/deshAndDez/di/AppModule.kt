package com.deshAndDez.di

//import com.deshAndDez.data.remote.firebase.FirebaseService
//import com.deshAndDez.data.remote.firebase.FirebaseServiceImp
import com.deshAndDez.data.repositories.aboutApp.AboutAppRepository
import com.deshAndDez.data.repositories.aboutApp.AboutAppRepositoryImp
import com.deshAndDez.data.repositories.account.AccountRepository
import com.deshAndDez.data.repositories.account.AccountRepositoryImp
import com.deshAndDez.data.repositories.core.CoreRepository
import com.deshAndDez.data.repositories.core.CoreRepositoryImp
import com.deshAndDez.data.repositories.notification.NotificationRepository
import com.deshAndDez.data.repositories.notification.NotificationRepositoryImp
import com.deshAndDez.data.repositories.settings.SettingsRepository
import com.deshAndDez.data.repositories.settings.SettingsRepositoryImp
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
//    @Binds
//    abstract fun provideFirebaseService(firebaseServiceImp: FirebaseServiceImp): FirebaseService
    @Binds
    abstract fun provideAboutAppRepository(aboutAppRepositoryImp: AboutAppRepositoryImp) : AboutAppRepository


}
package com.tmalty.di

import com.tmalty.commons.events.EventBus
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object EventBusModule {
    @Provides
    fun provideStringEventBus(): EventBus<String> {
        return EventBus.getInstance("StringEventBus")
    }

    @Provides
    fun provideIntEventBus(): EventBus<Int> {
        return EventBus.getInstance("IntEventBus")
    }
}

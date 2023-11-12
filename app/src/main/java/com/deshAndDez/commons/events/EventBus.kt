package com.deshAndDez.commons.events

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


class EventBus<T> private constructor() {
    private val eventChannel = MutableSharedFlow<T>(
        replay = 0,
        extraBufferCapacity = 64,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    fun post(event: T) {
        GlobalScope.launch(Dispatchers.Default) {
            eventChannel.emit(event)
        }
    }

    fun asFlow(): Flow<T> {
        return eventChannel.asSharedFlow()
    }

    companion object {
        private val instanceMap = mutableMapOf<String, EventBus<*>>()

        @Suppress("UNCHECKED_CAST")
        fun <T> getInstance(tag: String): EventBus<T> {
            return instanceMap.getOrPut(tag) { EventBus<T>() } as EventBus<T>
        }
    }
}
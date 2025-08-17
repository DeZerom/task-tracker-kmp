package ru.dezerom.tasktracker.core.tools.eventBus

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

open class BaseEventBus<E> {
    private val _events = MutableSharedFlow<E>()

    suspend fun sendEvent(event: E) {
        _events.emit(event)
    }

    fun observeEvents(): Flow<E> {
        return _events.asSharedFlow()
    }
}
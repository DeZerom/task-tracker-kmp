package ru.dezerom.tasktracker.di.providers

import com.arkivanov.decompose.ComponentContext

class RootContextProvider(private val rootContext: ComponentContext) {
    fun get() = rootContext
}
package ru.dezerom.tasktracker.di

import com.arkivanov.decompose.ComponentContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.dezerom.tasktracker.di.providers.RootContextProvider

fun rootModule(rootContext: ComponentContext) = module {
    single { RootContextProvider(rootContext) }
    singleOf(RootContextProvider::get)
}
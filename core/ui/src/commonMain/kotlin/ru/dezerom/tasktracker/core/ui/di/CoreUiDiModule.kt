package ru.dezerom.tasktracker.core.ui.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.dezerom.tasktracker.core.ui.decompose.DefaultSnackbarComponent
import ru.dezerom.tasktracker.core.ui.decompose.SnackbarComponent

val coreUiDiModule = module {
    singleOf(::DefaultSnackbarComponent) bind SnackbarComponent::class
}
package ru.dezerom.tasktracker.di

import com.arkivanov.decompose.ComponentContext
import org.koin.core.module.Module
import ru.dezerom.tasktracker.auth.data.di.authDataDiModule
import ru.dezerom.tasktracker.auth.domain.di.authDomainDiModule
import ru.dezerom.tasktracker.core.data.di.coreDataDiModule
import ru.dezerom.tasktracker.core.ui.di.coreUiDiModule

fun allModules(rootContext: ComponentContext): List<Module> {
    return listOf(
        rootModule(rootContext),

        coreDataDiModule,
        coreUiDiModule,

        authDataDiModule,
        authDomainDiModule
    )
}
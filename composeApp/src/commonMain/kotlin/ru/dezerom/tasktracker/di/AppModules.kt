package ru.dezerom.tasktracker.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.arkivanov.decompose.ComponentContext
import org.koin.core.module.Module
import ru.dezerom.tasktracker.auth.data.di.authDataDiModule
import ru.dezerom.tasktracker.auth.domain.di.authDomainDiModule
import ru.dezerom.tasktracker.core.data.di.coreDataDiModule
import ru.dezerom.tasktracker.core.ui.di.coreUiDiModule

fun allModules(
    rootContext: ComponentContext,
    dataStore: DataStore<Preferences>
): List<Module> {
    return listOf(
        rootModule(rootContext),

        coreDataDiModule(dataStore),
        coreUiDiModule,

        authDataDiModule,
        authDomainDiModule
    )
}
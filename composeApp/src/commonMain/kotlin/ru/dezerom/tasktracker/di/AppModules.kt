package ru.dezerom.tasktracker.di

import ru.dezerom.tasktracker.auth.data.di.authDataDiModule
import ru.dezerom.tasktracker.auth.domain.di.authDomainDiModule
import ru.dezerom.tasktracker.core.data.di.coreDataDiModule

val allModules = listOf(
    coreDataDiModule,

    authDataDiModule,
    authDomainDiModule
)
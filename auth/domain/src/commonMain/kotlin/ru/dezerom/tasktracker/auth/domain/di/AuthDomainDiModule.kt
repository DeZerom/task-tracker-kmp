package ru.dezerom.tasktracker.auth.domain.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.dezerom.tasktracker.auth.domain.AuthInteractor

val authDomainDiModule = module {
    singleOf(::AuthInteractor)
}
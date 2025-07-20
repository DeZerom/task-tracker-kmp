package ru.dezerom.tasktracker.auth.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.dezerom.tasktracker.auth.data.network.AuthApi
import ru.dezerom.tasktracker.auth.data.network.AuthApiImpl
import ru.dezerom.tasktracker.auth.data.repository.AuthRepository
import ru.dezerom.tasktracker.auth.data.repository.AuthRepositoryImpl

val authDataDiModule = module {
    singleOf(::AuthApiImpl) bind AuthApi::class
    singleOf(::AuthRepositoryImpl) bind AuthRepository::class
}
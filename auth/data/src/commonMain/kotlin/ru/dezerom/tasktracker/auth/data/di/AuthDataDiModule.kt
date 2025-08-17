package ru.dezerom.tasktracker.auth.data.di

import io.ktor.client.HttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module
import ru.dezerom.tasktracker.auth.data.cache.AuthCache
import ru.dezerom.tasktracker.auth.data.network.AuthApi
import ru.dezerom.tasktracker.auth.data.network.AuthApiImpl
import ru.dezerom.tasktracker.auth.data.repository.AuthRepository
import ru.dezerom.tasktracker.auth.data.repository.AuthRepositoryImpl
import ru.dezerom.tasktracker.core.data.di.DefaultHttpClient
import ru.dezerom.tasktracker.core.data.network.tokensManager.TokensManager

val authDataDiModule = module {
    singleOf(::AuthCache)
    single {
        val client: HttpClient = get(DefaultHttpClient)
        AuthApiImpl(client)
    } bind AuthApi::class

    singleOf(::AuthRepositoryImpl) binds arrayOf(AuthRepository::class, TokensManager::class)
}
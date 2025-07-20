package ru.dezerom.tasktracker.core.data.di

import io.ktor.client.HttpClient
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.dezerom.tasktracker.core.data.network.client.cioHttpClient

val coreDataDiModule = module {
    single { cioHttpClient } bind HttpClient::class
}
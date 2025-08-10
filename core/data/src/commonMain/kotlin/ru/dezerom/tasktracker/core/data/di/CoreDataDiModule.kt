package ru.dezerom.tasktracker.core.data.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import io.ktor.client.HttpClient
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.dezerom.tasktracker.core.data.cache.DataStoreKeyValueCache
import ru.dezerom.tasktracker.core.data.cache.KeyValueCache
import ru.dezerom.tasktracker.core.data.network.client.cioHttpClient

fun coreDataDiModule(dataStore: DataStore<Preferences>) = module {
    single { DataStoreKeyValueCache(dataStore) } bind KeyValueCache::class
    single { cioHttpClient } bind HttpClient::class
}
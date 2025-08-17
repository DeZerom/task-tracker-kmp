package ru.dezerom.tasktracker.core.data.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.dezerom.tasktracker.core.data.cache.DataStoreKeyValueCache
import ru.dezerom.tasktracker.core.data.cache.KeyValueCache
import ru.dezerom.tasktracker.core.data.di.providers.HttpClientProvider
import ru.dezerom.tasktracker.core.data.network.client.cioHttpClient
import ru.dezerom.tasktracker.core.tools.eventBus.AuthEventsBus

object DefaultHttpClient : Qualifier {
    override val value: QualifierValue = "default_http_client"
}

object AuthorizedHttpClient : Qualifier {
    override val value: QualifierValue = "authorized_http_client"
}

fun coreDataDiModule(dataStore: DataStore<Preferences>) = module {
    single { DataStoreKeyValueCache(dataStore) } bind KeyValueCache::class
    single(DefaultHttpClient) { cioHttpClient } bind HttpClient::class

    singleOf(::AuthEventsBus)
    singleOf(::HttpClientProvider)
    single(AuthorizedHttpClient) {
        val provider: HttpClientProvider = get()
        provider.get()
    } bind HttpClient::class
}
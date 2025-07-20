package ru.dezerom.tasktracker.core.data.network.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.defaultRequest

internal val cioHttpClient = HttpClient(CIO) {
    defaultRequest {
        url("http://185.125.101.41:8080/")
    }
}
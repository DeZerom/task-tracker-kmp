package ru.dezerom.tasktracker.core.data.network.calls

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Url

suspend fun HttpClient.getRequest(
    url: String,
): HttpResponse = get(Url(url))
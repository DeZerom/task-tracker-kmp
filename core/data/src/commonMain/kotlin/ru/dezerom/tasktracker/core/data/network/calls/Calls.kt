package ru.dezerom.tasktracker.core.data.network.calls

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

suspend fun HttpClient.postRequest(
    url: String,
    body: Any
): HttpResponse {
    return post {
        url(url)
        contentType(ContentType.Application.Json)
        setBody(body)
    }
}
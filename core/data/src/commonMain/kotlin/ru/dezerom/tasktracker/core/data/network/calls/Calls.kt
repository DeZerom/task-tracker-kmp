package ru.dezerom.tasktracker.core.data.network.calls

import com.diamondedge.logging.logging
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.Url
import ru.dezerom.tasktracker.core.data.models.ResponseDto

private val log = logging()

suspend fun <T> HttpClient.getRequest(
    url: String,
): HttpResponse = get(Url(url))
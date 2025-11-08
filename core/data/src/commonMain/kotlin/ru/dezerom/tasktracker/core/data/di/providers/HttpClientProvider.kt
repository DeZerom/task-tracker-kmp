package ru.dezerom.tasktracker.core.data.di.providers

import io.ktor.client.HttpClient
import io.ktor.client.call.HttpClientCall
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.Sender
import io.ktor.client.plugins.plugin
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.HttpStatusCode
import ru.dezerom.tasktracker.core.data.network.client.cioHttpClient
import ru.dezerom.tasktracker.core.data.network.tokensManager.TokensManager
import ru.dezerom.tasktracker.core.tools.eventBus.AuthEventsBus
import ru.dezerom.tasktracker.core.tools.eventBus.UnauthorizedEvent

class HttpClientProvider(
    private val tokensManager: TokensManager,
    private val authEventsBus: AuthEventsBus,
) {
    fun get(): HttpClient {
        cioHttpClient.plugin(HttpSend).intercept { request ->
            val result = sendRequest(request)

            if (result.response.status != HttpStatusCode.Unauthorized) {
                return@intercept result
            }

            val refreshResult = tokensManager.refreshTokens()
            if (refreshResult.isFailure) {
                tokensManager.clearTokens()
                authEventsBus.sendEvent(UnauthorizedEvent)
                return@intercept result
            }

            val newResult = sendRequest(request)
            if (newResult.response.status == HttpStatusCode.Unauthorized) {
                authEventsBus.sendEvent(UnauthorizedEvent)
            }

            newResult
        }

        return cioHttpClient
    }

    private suspend fun Sender.sendRequest(request: HttpRequestBuilder): HttpClientCall {
        val token = tokensManager.getAuthToken()
        if (token != null) request.headers.append(AUTH_HEADER, "Bearer $token")

        return execute(request)
    }

    companion object {
        private const val AUTH_HEADER = "Authorization"
    }
}
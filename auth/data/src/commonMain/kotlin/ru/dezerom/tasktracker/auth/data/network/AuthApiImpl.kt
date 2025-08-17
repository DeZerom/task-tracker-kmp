package ru.dezerom.tasktracker.auth.data.network

import io.ktor.client.HttpClient
import ru.dezerom.tasktracker.auth.data.network.models.CredentialsNetworkDto
import ru.dezerom.tasktracker.auth.data.network.models.TokensNetworkDto
import ru.dezerom.tasktracker.core.data.models.responses.BooleanResponse
import ru.dezerom.tasktracker.core.data.network.calls.postRequest
import ru.dezerom.tasktracker.core.data.utils.safeApiCall

internal class AuthApiImpl(
    private val httpClient: HttpClient
) : AuthApi {
    override suspend fun register(login: String, password: String): Result<BooleanResponse> {
        return safeApiCall {
            httpClient.postRequest(
                url = REGISTRATION,
                body = CredentialsNetworkDto(
                    login = login,
                    password = password
                )
            )
        }
    }

    override suspend fun authorize(
        login: String,
        password: String
    ): Result<TokensNetworkDto> {
        return safeApiCall {
            httpClient.postRequest(
                url = AUTH,
                body = CredentialsNetworkDto(
                    login = login,
                    password = password
                )
            )
        }
    }

    override suspend fun refreshTokens(refreshToken: String): Result<TokensNetworkDto> {
        return safeApiCall {
            httpClient.postRequest(
                url = REFRESH,
                headers = mapOf(AUTH_HEADER to refreshToken)
            )
        }
    }

    companion object {
        private const val AUTH_BASE = "auth"

        private const val AUTH = "$AUTH_BASE/auth"
        private const val REGISTRATION = "$AUTH_BASE/register"
        private const val REFRESH = "$AUTH_BASE/refresh"

        private const val AUTH_HEADER = "Authorization"
    }
}
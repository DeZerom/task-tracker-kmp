package ru.dezerom.tasktracker.auth.data.network

import io.ktor.client.HttpClient
import ru.dezerom.tasktracker.auth.data.network.models.CredentialsDto
import ru.dezerom.tasktracker.core.data.models.responses.BooleanResponse
import ru.dezerom.tasktracker.core.data.network.calls.postRequest
import ru.dezerom.tasktracker.core.data.utils.safeApiCall

internal class AuthApiImpl(
    private val httpClient: HttpClient
) : AuthApi {
    override suspend fun register(login: String, password: String): Result<BooleanResponse> {
        return safeApiCall {
            httpClient.postRequest(
                url = "auth/register",
                body = CredentialsDto(
                    login = login,
                    password = password
                )
            )
        }
    }
}
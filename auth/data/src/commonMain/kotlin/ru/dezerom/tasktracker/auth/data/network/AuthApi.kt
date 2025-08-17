package ru.dezerom.tasktracker.auth.data.network

import ru.dezerom.tasktracker.auth.data.network.models.TokensNetworkDto
import ru.dezerom.tasktracker.core.data.models.responses.BooleanResponse

internal interface AuthApi {
    suspend fun register(login: String, password: String): Result<BooleanResponse>

    suspend fun authorize(login: String, password: String): Result<TokensNetworkDto>

    suspend fun refreshTokens(refreshToken: String): Result<TokensNetworkDto>
}
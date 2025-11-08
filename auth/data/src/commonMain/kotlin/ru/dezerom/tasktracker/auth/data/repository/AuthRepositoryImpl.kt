package ru.dezerom.tasktracker.auth.data.repository

import ru.dezerom.tasktracker.auth.data.cache.AuthCache
import ru.dezerom.tasktracker.auth.data.network.AuthApi
import ru.dezerom.tasktracker.core.data.network.tokensManager.TokensManager
import ru.dezerom.tasktracker.core.tools.customErrors.NetworkError

internal class AuthRepositoryImpl(
    private val authApi: AuthApi,
    private val authCache: AuthCache
) : AuthRepository, TokensManager {
    override suspend fun authorize(login: String, password: String): Result<Boolean> {
        val tokens = authApi.authorize(login, password).fold(
            onSuccess = { it },
            onFailure = { return Result.failure(it) }
        )

        authCache.saveTokens(accessToken = tokens.accessToken, refreshToken = tokens.refreshToken)

        return Result.success(true)
    }

    override suspend fun register(login: String, password: String): Result<Boolean> {
        return authApi.register(login, password).map { it.response }
    }

    override suspend fun getAuthToken(): String? {
        return authCache.getAccessToken()
    }

    override suspend fun refreshTokens(): Result<Boolean> {
        val refresh = authCache.getRefreshToken() ?: return Result.failure(NetworkError.unauthorizedNetworkError())

        val tokens = authApi.refreshTokens("Bearer $refresh").fold(
            onSuccess = { it },
            onFailure = { return Result.failure(it) }
        )

        authCache.saveTokens(accessToken = tokens.accessToken, refreshToken = tokens.refreshToken)

        return Result.success(true)
    }

    override suspend fun clearTokens() {
        unAuthorize()
    }

    override suspend fun unAuthorize() {
        authCache.clear()
    }
}
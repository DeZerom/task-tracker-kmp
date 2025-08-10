package ru.dezerom.tasktracker.auth.data.repository

import ru.dezerom.tasktracker.auth.data.cache.AuthCache
import ru.dezerom.tasktracker.auth.data.network.AuthApi

internal class AuthRepositoryImpl(
    private val authApi: AuthApi,
    private val authCache: AuthCache
): AuthRepository {
    override suspend fun authorize(login: String, password: String): Result<Boolean> {
        return authApi.authorize(login, password).map { true }
    }

    override suspend fun register(login: String, password: String): Result<Boolean> {
        val tokens = authApi.authorize(login, password).fold(
            onSuccess = { it },
            onFailure = { return Result.failure(it) }
        )

        authCache.saveTokens(accessToken = tokens.accessToken, refreshToken = tokens.refreshToken)

        return Result.success(true)
    }

    override suspend fun getAuthToken(): String? {
        return authCache.getAccessToken()
    }

    override suspend fun refreshTokens(): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun unAuthorize() {
        authCache.clear()
    }
}
package ru.dezerom.tasktracker.auth.data.repository

import ru.dezerom.tasktracker.auth.data.network.AuthApi

internal class AuthRepositoryImpl(
    private val authApi: AuthApi
): AuthRepository {
    override suspend fun authorize(login: String, password: String): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun register(login: String, password: String): Result<Boolean> {
        return authApi.register(login, password)
    }

    override suspend fun getAuthToken(): String? {
        TODO("Not yet implemented")
    }

    override suspend fun refreshTokens(): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun unAuthorize(): Result<Boolean> {
        TODO("Not yet implemented")
    }
}
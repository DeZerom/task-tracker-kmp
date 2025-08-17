package ru.dezerom.tasktracker.core.data.network.tokensManager

interface TokensManager {
    suspend fun getAuthToken(): String?

    suspend fun refreshTokens(): Result<Boolean>
}
package ru.dezerom.tasktracker.auth.data.cache

import ru.dezerom.tasktracker.core.data.cache.KeyValueCache

internal class AuthCache(
    private val cache: KeyValueCache
) {
    suspend fun saveTokens(accessToken: String, refreshToken: String) {
        cache.writeString(ACCESS_TOKEN_KEY, accessToken)
        cache.writeString(REFRESH_TOKEN_KEY, refreshToken)
    }

    suspend fun getAccessToken(): String? {
        return cache.readString(ACCESS_TOKEN_KEY)
    }

    suspend fun clear() {
        cache.clearAll()
    }

    companion object {
        private const val ACCESS_TOKEN_KEY = "auth_access_token_key"
        private const val REFRESH_TOKEN_KEY = "auth_refresh_token_key"
    }
}
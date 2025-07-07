package ru.dezerom.tasktracker.auth.data.repository

class AuthRepositoryImpl: AuthRepository {
    override suspend fun authorize(login: String, password: String): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun register(login: String, password: String): Result<Boolean> {
        TODO("Not yet implemented")
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
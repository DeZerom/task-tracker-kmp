package ru.dezerom.tasktracker.auth.domain

import ru.dezerom.tasktracker.auth.data.repository.AuthRepository

class AuthInteractor constructor(
    private val authRepository: AuthRepository
)  {
    suspend fun isAuthorized(): Boolean =
        !authRepository.getAuthToken().isNullOrBlank()

    suspend fun authorize(login: String, pass: String): Result<Boolean> {
        return authRepository.authorize(login, pass)
    }

    suspend fun register(login: String, pass: String): Result<Boolean> {
        return authRepository.register(login, pass)
    }
}
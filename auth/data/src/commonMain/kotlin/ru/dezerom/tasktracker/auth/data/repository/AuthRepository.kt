package ru.dezerom.tasktracker.auth.data.repository

interface AuthRepository {
    suspend fun authorize(login: String, password: String): Result<Boolean>

    suspend fun register(login: String, password: String): Result<Boolean>

    suspend fun unAuthorize()

    suspend fun getAuthToken(): String?
}
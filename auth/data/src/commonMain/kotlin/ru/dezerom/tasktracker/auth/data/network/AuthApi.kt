package ru.dezerom.tasktracker.auth.data.network

internal interface AuthApi {
    suspend fun register(login: String, password: String): Result<Boolean>
}
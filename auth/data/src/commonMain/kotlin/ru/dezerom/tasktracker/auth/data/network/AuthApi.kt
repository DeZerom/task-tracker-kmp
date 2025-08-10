package ru.dezerom.tasktracker.auth.data.network

import ru.dezerom.tasktracker.core.data.models.responses.BooleanResponse

internal interface AuthApi {
    suspend fun register(login: String, password: String): Result<BooleanResponse>
}
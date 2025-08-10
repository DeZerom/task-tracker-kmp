package ru.dezerom.tasktracker.auth.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CredentialsNetworkDto(
    @SerialName("login")
    val login: String,
    @SerialName("password")
    val password: String
)

package ru.dezerom.tasktracker.core.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDto<T>(
    @SerialName("success")
    val success: Boolean,

    @SerialName("body")
    val body: T,

    @SerialName("error")
    val error: String? = null
)

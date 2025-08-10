package ru.dezerom.tasktracker.core.data.models.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooleanResponse(
    @SerialName("response")
    val response: Boolean
)

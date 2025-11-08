package ru.dezerom.tasktracker.taskList.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TaskNetworkModel(
    @SerialName("id")
    val id: String? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("description")
    val description: String? = null,

    @SerialName("deadline")
    val deadline: Long? = null,

    @SerialName("created_at")
    val createdAt: Long? = null,

    @SerialName("is_completed")
    val isCompleted: Boolean? = null,

    @SerialName("completed_at")
    val completedAt: Long? = null,
)
package ru.dezerom.tasktracker.taskList.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TasksListNetworkModel(
    @SerialName("tasks")
    val tasks: List<TaskNetworkModel> = emptyList()
)

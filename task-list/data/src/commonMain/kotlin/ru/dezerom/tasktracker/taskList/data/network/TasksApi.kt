package ru.dezerom.tasktracker.taskList.data.network

import ru.dezerom.tasktracker.taskList.data.network.models.TasksListNetworkModel

internal interface TasksApi {
    suspend fun getTasks(): Result<TasksListNetworkModel>
}
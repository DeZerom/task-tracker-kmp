package ru.dezerom.tasktracker.taskList.data.network

import io.ktor.client.HttpClient
import ru.dezerom.tasktracker.core.data.network.calls.getRequest
import ru.dezerom.tasktracker.core.data.utils.safeApiCall
import ru.dezerom.tasktracker.taskList.data.network.models.TasksListNetworkModel

internal class TasksApiImpl(
    private val client: HttpClient
) : TasksApi {
    override suspend fun getTasks(): Result<TasksListNetworkModel> {
        return safeApiCall {
            client.getRequest(
                url = "/tasks/all"
            )
        }
    }
}
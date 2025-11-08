package ru.dezerom.tasktracker.taskList.data.repository

import ru.dezerom.tasktracker.taskList.data.models.TaskDataModel
import ru.dezerom.tasktracker.taskList.data.network.TasksApi
import ru.dezerom.tasktracker.taskList.data.network.mappers.toData

internal class DefaultTasksRepository(
    val api: TasksApi
) : TasksRepository {
    override suspend fun getTasks(): Result<List<TaskDataModel>> {
        return api.getTasks().map { response -> response.toData() }
    }
}
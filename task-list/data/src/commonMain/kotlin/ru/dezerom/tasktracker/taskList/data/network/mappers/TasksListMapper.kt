package ru.dezerom.tasktracker.taskList.data.network.mappers

import ru.dezerom.tasktracker.taskList.data.models.TaskDataModel
import ru.dezerom.tasktracker.taskList.data.network.models.TasksListNetworkModel

internal fun TasksListNetworkModel.toData(): List<TaskDataModel> {
    return tasks.map {
        TaskDataModel(
            id = it.id.orEmpty(),
            name = it.name.orEmpty(),
            description = it.description.orEmpty(),
            deadline = it.deadline,
            createdAt = it.createdAt ?: 0,
            isCompleted = it.isCompleted ?: false,
            completedAt = it.completedAt
        )
    }
}
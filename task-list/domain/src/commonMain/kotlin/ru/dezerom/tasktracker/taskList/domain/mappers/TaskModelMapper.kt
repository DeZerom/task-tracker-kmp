package ru.dezerom.tasktracker.taskList.domain.mappers

import ru.dezerom.tasktracker.taskList.data.models.TaskDataModel
import ru.dezerom.tasktracker.taskList.domain.models.TaskModel

fun TaskDataModel.toDomain(): TaskModel {
    return TaskModel(
        id = id,
        name = name,
        description = description,
        deadline = deadline,
        createdAt = createdAt,
        isCompleted = isCompleted,
        completedAt = completedAt
    )
}
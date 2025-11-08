package ru.dezerom.tasktracker.taskList.data.repository

import ru.dezerom.tasktracker.taskList.data.models.TaskDataModel

interface TasksRepository {
    suspend fun getTasks(): Result<List<TaskDataModel>>
}
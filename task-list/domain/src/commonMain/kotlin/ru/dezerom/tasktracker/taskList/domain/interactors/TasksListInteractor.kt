package ru.dezerom.tasktracker.taskList.domain.interactors

import ru.dezerom.tasktracker.taskList.data.repository.TasksRepository
import ru.dezerom.tasktracker.taskList.domain.mappers.toDomain
import ru.dezerom.tasktracker.taskList.domain.models.TaskModel

class TasksListInteractor(
    val tasksListRepository: TasksRepository
) {
    suspend fun getTasks(): Result<List<TaskModel>> {
        return tasksListRepository.getTasks().map { tasks ->
            tasks.map { it.toDomain() }
        }
    }
}
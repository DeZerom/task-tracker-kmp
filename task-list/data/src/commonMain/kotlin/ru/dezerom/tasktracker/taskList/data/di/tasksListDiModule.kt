package ru.dezerom.tasktracker.taskList.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.dezerom.tasktracker.core.data.di.AuthorizedHttpClient
import ru.dezerom.tasktracker.taskList.data.network.TasksApi
import ru.dezerom.tasktracker.taskList.data.network.TasksApiImpl
import ru.dezerom.tasktracker.taskList.data.repository.DefaultTasksRepository
import ru.dezerom.tasktracker.taskList.data.repository.TasksRepository

val tasksListDiModule = module {
    single { TasksApiImpl(client = get(AuthorizedHttpClient)) } bind TasksApi::class
    singleOf(::DefaultTasksRepository) bind TasksRepository::class
}
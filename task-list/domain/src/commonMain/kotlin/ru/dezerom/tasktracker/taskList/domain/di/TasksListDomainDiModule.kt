package ru.dezerom.tasktracker.taskList.domain.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.dezerom.tasktracker.taskList.domain.interactors.TasksListInteractor

val tasksListDomainModule = module {
    factoryOf(::TasksListInteractor)
}
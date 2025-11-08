package ru.dezerom.tasktracker.taskList.ui.taskList

import ru.dezerom.tasktracker.core.ui.store.BaseStore

internal class TasksListStore : BaseStore<TasksListContract.Event, TasksListContract.State, TasksListContract.SideEffect>() {
    override fun initState(): TasksListContract.State {
        return TasksListContract.State.Loading
    }

    override suspend fun handleEvent(event: TasksListContract.Event) {
        TODO("Not yet implemented")
    }
}
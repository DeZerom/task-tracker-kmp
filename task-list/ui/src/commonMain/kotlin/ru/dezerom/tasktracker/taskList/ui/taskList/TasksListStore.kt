package ru.dezerom.tasktracker.taskList.ui.taskList

import kotlinx.coroutines.launch
import ru.dezerom.tasktracker.core.ui.store.BaseStore
import ru.dezerom.tasktracker.taskList.domain.interactors.TasksListInteractor
import ru.dezerom.tasktracker.taskList.domain.models.TaskModel

internal class TasksListStore(
    private val tasksListInteractor: TasksListInteractor,
) : BaseStore<TasksListContract.Event, TasksListContract.State, TasksListContract.SideEffect>() {
    init {
        loadData()
    }

    override fun initState(): TasksListContract.State {
        return TasksListContract.State.Loading
    }

    override suspend fun handleEvent(event: TasksListContract.Event) {
        TODO("Not yet implemented")
    }

    private fun loadData() {
        coroutineScope.launch {
            tasksListInteractor.getTasks().fold(
                onSuccess = {
                    setState(
                        TasksListContract.State.Loaded(
                            tasks = it.map(TaskModel::toState),
                            isRefreshing = false,
                        )
                    )
                },
                onFailure = {
                    setSideEffect(TasksListContract.SideEffect.ShowError(it))
                }
            )
        }
    }
}
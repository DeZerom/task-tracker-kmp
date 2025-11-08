package ru.dezerom.tasktracker.taskList.ui.taskList

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

interface TasksListComponent {
    val state: StateFlow<TasksListContract.State>
}

internal class DefaultTasksListComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {

}
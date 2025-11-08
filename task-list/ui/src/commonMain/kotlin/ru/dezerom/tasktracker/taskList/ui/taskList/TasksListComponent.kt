package ru.dezerom.tasktracker.taskList.ui.taskList

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import kotlinx.coroutines.flow.StateFlow

interface TasksListComponent {
    val state: StateFlow<TasksListContract.State>

    fun onAddClicked()
    fun onTryAgainClicked()
    fun onRefreshClicked()
    fun onChangeCompleteStatus()
    fun onEditClicked()
    fun onDeleteClicked()
}

internal class DefaultTasksListComponent(
    componentContext: ComponentContext
) : TasksListComponent, ComponentContext by componentContext {
    private val store = instanceKeeper.getOrCreate {
        TasksListStore()
    }

    override val state: StateFlow<TasksListContract.State> = store.state

    override fun onAddClicked() {
        TODO("Not yet implemented")
    }

    override fun onTryAgainClicked() {
        TODO("Not yet implemented")
    }

    override fun onRefreshClicked() {
        TODO("Not yet implemented")
    }

    override fun onChangeCompleteStatus() {
        TODO("Not yet implemented")
    }

    override fun onEditClicked() {
        TODO("Not yet implemented")
    }

    override fun onDeleteClicked() {
        TODO("Not yet implemented")
    }
}
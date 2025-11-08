package ru.dezerom.tasktracker.taskList.ui.taskList

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import ru.dezerom.tasktracker.core.ui.decompose.SnackbarComponent
import ru.dezerom.tasktracker.core.ui.tools.showError

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
    componentContext: ComponentContext,
    snackbarComponent: SnackbarComponent,
) : TasksListComponent, ComponentContext by componentContext, SnackbarComponent by snackbarComponent, KoinComponent {
    private val store = instanceKeeper.getOrCreate {
        TasksListStore(
            tasksListInteractor = get()
        )
    }

    override val state: StateFlow<TasksListContract.State> = store.state

    private val coroutineScope = coroutineScope()

    init {
        store.sideEffect.onEach(::processSideEffect).launchIn(coroutineScope)
    }

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

    private fun processSideEffect(effect: TasksListContract.SideEffect) {
        when (effect) {
            is TasksListContract.SideEffect.ShowError -> {
                showError(effect.error)
            }
        }
    }
}
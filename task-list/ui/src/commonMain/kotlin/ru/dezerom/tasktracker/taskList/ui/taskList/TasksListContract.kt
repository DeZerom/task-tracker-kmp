package ru.dezerom.tasktracker.taskList.ui.taskList

import ru.dezerom.tasktracker.core.tools.stringContainer.StringContainer
import ru.dezerom.tasktracker.taskList.domain.models.TaskModel

class TasksListContract {
    sealed class State {
        data object Loading: State()

        data class Loaded(
            val tasks: List<TaskUiState>,
            val isRefreshing: Boolean,
            val editingTask: TaskModel? = null,
            val deleteTaskAlertState: DeleteTaskAlertState? = null,
        ): State()

        data class Error(
            val error: StringContainer
        ): State()
    }

    sealed class Event {
        data object TryAgainClicked: Event()
        data object Refresh: Event()
        data object EditTaskClosed: Event()
        data object CancelDelete: Event()

        class ChangeCompleteStatus(val taskId: String): Event()
        class EditClicked(val taskId: String): Event()
        class DeleteClicked(val taskId: String): Event()
        class ConfirmDelete(val taskId: String): Event()
    }

    sealed class SideEffect {}
}

class TaskUiState(
    val task: TaskModel,
    val isLoading: Boolean,
)

data class DeleteTaskAlertState(
    val taskId: String,
    val taskName: String
)
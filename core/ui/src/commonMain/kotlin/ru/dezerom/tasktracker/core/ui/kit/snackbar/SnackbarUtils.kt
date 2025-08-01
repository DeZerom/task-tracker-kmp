package ru.dezerom.tasktracker.core.ui.kit.snackbar

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import ru.dezerom.tasktracker.core.tools.stringContainer.StringContainer

suspend fun SnackbarHostState.showSuccess(container: StringContainer) = showSnackbar(
    KitSnackbarVisuals.Success(
        messageContainer = container,
        message = "",
        actionLabel = "",
        withDismissAction = false,
        duration = SnackbarDuration.Short,
    )
)

suspend fun SnackbarHostState.showError(container: StringContainer) = showSnackbar(
    KitSnackbarVisuals.Error(
        messageContainer = container,
        message = "",
        actionLabel = "",
        withDismissAction = false,
        duration = SnackbarDuration.Short
    )
)
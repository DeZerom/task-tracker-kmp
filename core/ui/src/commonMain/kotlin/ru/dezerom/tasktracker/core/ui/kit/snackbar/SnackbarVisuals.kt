package ru.dezerom.tasktracker.core.ui.kit.snackbar

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals
import ru.dezerom.tasktracker.core.tools.stringContainer.StringContainer

sealed class KitSnackbarVisuals: SnackbarVisuals {
    abstract val messageContainer: StringContainer

    class Success(
        override val messageContainer: StringContainer,
        override val actionLabel: String?,
        override val duration: SnackbarDuration,
        override val message: String,
        override val withDismissAction: Boolean
    ) : KitSnackbarVisuals()

    class Error(
        override val messageContainer: StringContainer,
        override val actionLabel: String?,
        override val duration: SnackbarDuration,
        override val message: String,
        override val withDismissAction: Boolean
    ) : KitSnackbarVisuals()

}
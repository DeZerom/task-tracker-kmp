package ru.dezerom.tasktracker.core.ui.tools

import ru.dezerom.tasktracker.core.tools.customErrors.NetworkError
import ru.dezerom.tasktracker.core.tools.stringContainer.wrapInContainer
import ru.dezerom.tasktracker.core.ui.decompose.SnackbarComponent

fun SnackbarComponent.showError(throwable: Throwable) {
    val text = if (throwable is NetworkError) throwable.messageRes else (throwable.message ?: "").wrapInContainer()
    showError(text)
}
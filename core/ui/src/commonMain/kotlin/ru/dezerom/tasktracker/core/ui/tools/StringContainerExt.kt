package ru.dezerom.tasktracker.core.ui.tools

import androidx.compose.runtime.Composable
import ru.dezerom.tasktracker.core.tools.stringContainer.StringContainer

@Composable
fun StringContainer.getString(): String {
    return stringResource(this)
}

@Composable
private fun stringResource(container: StringContainer): String {
    return when (container) {
        is StringContainer.RawString -> container.str
        is StringContainer.StringRes -> org.jetbrains.compose.resources.stringResource(resource = container.res)
    }
}
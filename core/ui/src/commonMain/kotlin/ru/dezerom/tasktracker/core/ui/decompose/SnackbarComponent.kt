package ru.dezerom.tasktracker.core.ui.decompose

import androidx.compose.material3.SnackbarHostState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import ru.dezerom.tasktracker.core.tools.stringContainer.StringContainer
import ru.dezerom.tasktracker.core.ui.kit.snackbar.showError
import ru.dezerom.tasktracker.core.ui.kit.snackbar.showSuccess

interface SnackbarComponent {
    val snackbarHostState: SnackbarHostState

    fun showSuccess(text: StringContainer)
    fun showError(text: StringContainer)
}

internal class DefaultSnackbarComponent(
    componentContext: ComponentContext
) : SnackbarComponent, ComponentContext by componentContext {
    override val snackbarHostState = SnackbarHostState()

    private val coroutineScope = CoroutineScope(Job())

    init {
        lifecycle.doOnDestroy { coroutineScope.cancel() }
    }

    override fun showSuccess(text: StringContainer) {
        coroutineScope.launch {
            snackbarHostState.showSuccess(text)
        }
    }

    override fun showError(text: StringContainer) {
        coroutineScope.launch {
            snackbarHostState.showError(text)
        }
    }
}
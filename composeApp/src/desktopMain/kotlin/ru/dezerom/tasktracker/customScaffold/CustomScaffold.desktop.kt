package ru.dezerom.tasktracker.customScaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import ru.dezerom.tasktracker.core.ui.decompose.SnackbarComponent
import ru.dezerom.tasktracker.core.ui.kit.snackbar.KitSnackbarHost

@Composable
actual fun CustomScaffold(
    state: CustomScaffoldState,
    snackbarComponent: SnackbarComponent,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        snackbarHost = { KitSnackbarHost(snackbarComponent.snackbarHostState) }
    ) { padding ->
        content(padding)
    }
}
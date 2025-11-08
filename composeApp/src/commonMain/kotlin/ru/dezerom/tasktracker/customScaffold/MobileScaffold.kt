package ru.dezerom.tasktracker.customScaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import ru.dezerom.tasktracker.core.ui.customScaffold.CustomScaffoldState
import ru.dezerom.tasktracker.core.ui.customScaffold.CustomScaffoldTopBar
import ru.dezerom.tasktracker.core.ui.decompose.SnackbarComponent
import ru.dezerom.tasktracker.core.ui.kit.snackbar.KitSnackbarHost

@Composable
fun MobileCustomScaffold(
    state: CustomScaffoldState,
    snackbarComponent: SnackbarComponent,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { CustomScaffoldTopBar(state.topBarState) },
        snackbarHost = { KitSnackbarHost(snackbarComponent.snackbarHostState) },
        floatingActionButton = state.fab
    ) { padding ->
        content(padding)
    }
}
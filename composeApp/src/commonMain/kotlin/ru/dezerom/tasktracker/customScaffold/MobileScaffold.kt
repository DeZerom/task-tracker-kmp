package ru.dezerom.tasktracker.customScaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import ru.dezerom.tasktracker.core.ui.customScaffold.CustomScaffoldState
import ru.dezerom.tasktracker.core.ui.customScaffold.TopBarState
import ru.dezerom.tasktracker.core.ui.decompose.SnackbarComponent
import ru.dezerom.tasktracker.core.ui.kit.snackbar.KitSnackbarHost
import ru.dezerom.tasktracker.core.ui.kit.topBar.TopLevelTopBar

@Composable
fun MobileCustomScaffold(
    state: CustomScaffoldState,
    snackbarComponent: SnackbarComponent,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { TopBar(state.topBarState) },
        snackbarHost = { KitSnackbarHost(snackbarComponent.snackbarHostState) },
        floatingActionButton = state.fab
    ) { padding ->
        content(padding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(state: TopBarState) {
    when (state) {
        TopBarState.NoTopBar -> Unit
        is TopBarState.TopLevel -> {
            TopLevelTopBar(title = state.title, scrollBehavior = state.scrollBehavior)
        }
    }
}
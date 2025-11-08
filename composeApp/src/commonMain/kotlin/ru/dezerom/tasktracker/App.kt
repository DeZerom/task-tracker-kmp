package ru.dezerom.tasktracker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import ru.dezerom.tasktracker.core.ui.customScaffold.CustomScaffoldStateHolder
import ru.dezerom.tasktracker.core.ui.decompose.SnackbarComponent
import ru.dezerom.tasktracker.core.ui.kit.theme.TaskTrackerTheme
import ru.dezerom.tasktracker.customScaffold.CustomScaffold
import ru.dezerom.tasktracker.navigation.RootComponent
import ru.dezerom.tasktracker.navigation.RootContent

@Composable
@Preview
fun App(rootComponent: RootComponent) {
    val snackbarComponent: SnackbarComponent = koinInject()
    val customScaffoldState by CustomScaffoldStateHolder.state.collectAsState()

    TaskTrackerTheme {
        CustomScaffold(
            state = customScaffoldState,
            snackbarComponent = snackbarComponent
        ) {
            RootContent(rootComponent)
        }
    }
}
package ru.dezerom.tasktracker

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import ru.dezerom.tasktracker.core.ui.decompose.SnackbarComponent
import ru.dezerom.tasktracker.core.ui.kit.theme.TaskTrackerTheme
import ru.dezerom.tasktracker.customScaffold.CustomScaffold
import ru.dezerom.tasktracker.customScaffold.CustomScaffoldState
import ru.dezerom.tasktracker.navigation.RootComponent
import ru.dezerom.tasktracker.navigation.RootContent

@Composable
@Preview
fun App(rootComponent: RootComponent) {
    val snackbarComponent: SnackbarComponent = koinInject()
    TaskTrackerTheme {
        CustomScaffold(
            state = CustomScaffoldState(),
            snackbarComponent = snackbarComponent
        ) {
            RootContent(rootComponent)
        }
    }
}
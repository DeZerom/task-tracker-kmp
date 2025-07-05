package ru.dezerom.tasktracker

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.dezerom.tasktracker.core.ui.kit.theme.TaskTrackerTheme
import ru.dezerom.tasktracker.navigation.RootComponent
import ru.dezerom.tasktracker.navigation.RootContent

@Composable
@Preview
fun App(rootComponent: RootComponent) {
    TaskTrackerTheme {
        Scaffold {
            RootContent(rootComponent)
        }
    }
}
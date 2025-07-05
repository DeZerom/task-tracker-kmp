package ru.dezerom.tasktracker

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.dezerom.tasktracker.auth.ui.auth.AuthScreen
import ru.dezerom.tasktracker.core.ui.kit.theme.TaskTrackerTheme

@Composable
@Preview
fun App() {
    TaskTrackerTheme {
        Scaffold {
            AuthScreen()
        }
    }
}
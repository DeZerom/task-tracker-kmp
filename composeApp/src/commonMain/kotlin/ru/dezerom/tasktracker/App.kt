package ru.dezerom.tasktracker

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.dezerom.tasktracker.auth.ui.auth.AuthScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        AuthScreen()
    }
}
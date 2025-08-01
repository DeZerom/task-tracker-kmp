package ru.dezerom.tasktracker.customScaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@Composable
actual fun CustomScaffold(
    state: CustomScaffoldState,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold { padding ->
        content(padding)
    }
}
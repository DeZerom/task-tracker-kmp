package ru.dezerom.tasktracker.customScaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import ru.dezerom.tasktracker.core.ui.decompose.SnackbarComponent

@Composable
expect fun  CustomScaffold(
    state: CustomScaffoldState,
    snackbarComponent: SnackbarComponent,
    content: @Composable (PaddingValues) -> Unit
)
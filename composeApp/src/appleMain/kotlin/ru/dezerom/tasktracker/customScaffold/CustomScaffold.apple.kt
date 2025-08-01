package ru.dezerom.tasktracker.customScaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable

@androidx.compose.runtime.Composable
actual fun CustomScaffold(
    state: CustomScaffoldState,
    content: @Composable ((PaddingValues) -> Unit)
) {
    MobileCustomScaffold(state)
}
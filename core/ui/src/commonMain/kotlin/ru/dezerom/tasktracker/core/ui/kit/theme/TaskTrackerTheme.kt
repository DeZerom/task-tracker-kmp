package ru.dezerom.tasktracker.core.ui.kit.theme

import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import ru.dezerom.tasktracker.core.ui.kit.Colors
import ru.dezerom.tasktracker.core.ui.kit.TS

@Composable
fun TaskTrackerTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = darkColorScheme(
        background = Colors.background,
    )

    val textSelectionColors = remember {
        TextSelectionColors(
            handleColor = Colors.accent,
            backgroundColor = Colors.textSelectionBackground
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = TS,
        content = {
            CompositionLocalProvider(
                LocalContentColor provides Colors.white,
                LocalTextSelectionColors provides textSelectionColors
            ) {
                content()
            }
        }
    )
}
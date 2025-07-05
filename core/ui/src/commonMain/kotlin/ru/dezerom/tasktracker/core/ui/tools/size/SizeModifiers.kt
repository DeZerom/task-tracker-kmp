package ru.dezerom.tasktracker.core.ui.tools.size

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Modifier.singleElementWidth(
    size: WindowSizeClass
): Modifier {
    return if (size.widthSizeClass == WindowWidthSizeClass.Compact) {
        fillMaxWidth()
    } else {
        width(450.dp)
    }
}
package ru.dezerom.tasktracker

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.singleWindowApplication
import ru.dezerom.tasktracker.core.ui.tools.LocalWindowSize

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
fun main() = singleWindowApplication {
    val size = calculateWindowSizeClass()

    CompositionLocalProvider(
        LocalWindowSize provides size
    ) {
        App()
    }
}
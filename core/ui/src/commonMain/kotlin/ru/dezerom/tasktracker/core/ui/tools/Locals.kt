package ru.dezerom.tasktracker.core.ui.tools

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.compositionLocalOf

val LocalWindowSize = compositionLocalOf<WindowSizeClass> { error("Not initialized yet") }
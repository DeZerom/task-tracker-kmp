package ru.dezerom.tasktracker

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle
import org.koin.core.context.startKoin
import ru.dezerom.tasktracker.core.ui.tools.LocalWindowSize
import ru.dezerom.tasktracker.di.allModules
import ru.dezerom.tasktracker.navigation.DefaultRootComponent

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Suppress("Unused", "FunctionName")
fun MainViewController() = ComposeUIViewController {
    val context = remember { DefaultComponentContext(ApplicationLifecycle()) }
    startKoin { modules(allModules(context)) }

    val rootComponent = remember {
        DefaultRootComponent(context)
    }

    val size = calculateWindowSizeClass()

    CompositionLocalProvider(
        LocalWindowSize provides size
    ) {
        App(rootComponent)
    }
}
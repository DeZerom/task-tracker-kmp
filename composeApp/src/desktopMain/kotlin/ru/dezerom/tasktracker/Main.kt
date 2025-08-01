package ru.dezerom.tasktracker

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.singleWindowApplication
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.koin.core.context.startKoin
import ru.dezerom.tasktracker.core.ui.tools.LocalWindowSize
import ru.dezerom.tasktracker.di.allModules
import ru.dezerom.tasktracker.navigation.DefaultRootComponent
import javax.swing.SwingUtilities

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
fun main() {
    val lifecycle = LifecycleRegistry()

    val context = DefaultComponentContext(lifecycle = lifecycle)
    startKoin { modules(allModules(context)) }

    val rootComponent = runOnUiThread { 
        DefaultRootComponent(context)
    }

    singleWindowApplication {
        val size = calculateWindowSizeClass()

        CompositionLocalProvider(
            LocalWindowSize provides size
        ) {
            App(rootComponent)
        }
    }
}

internal fun <T> runOnUiThread(block: () -> T): T {
    if (SwingUtilities.isEventDispatchThread()) {
        return block()
    }

    var error: Throwable? = null
    var result: T? = null

    SwingUtilities.invokeAndWait {
        try {
            result = block()
        } catch (e: Throwable) {
            error = e
        }
    }

    error?.also { throw it }

    @Suppress("UNCHECKED_CAST")
    return result as T
}
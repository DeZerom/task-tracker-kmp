package ru.dezerom.tasktracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import com.arkivanov.decompose.defaultComponentContext
import org.koin.core.context.startKoin
import ru.dezerom.tasktracker.core.ui.tools.LocalWindowSize
import ru.dezerom.tasktracker.di.allModules
import ru.dezerom.tasktracker.navigation.DefaultRootComponent

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        startKoin { modules(allModules) }

        val rootComponent = DefaultRootComponent(defaultComponentContext())

        setContent {
            val size = calculateWindowSizeClass(this)

            CompositionLocalProvider(
                LocalWindowSize provides size
            ) {
                App(rootComponent)
            }
        }
    }
}
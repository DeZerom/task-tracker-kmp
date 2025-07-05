package ru.dezerom.tasktracker.auth.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import ru.dezerom.tasktracker.auth.ui.auth.AuthScreen

@Composable
fun AuthRootContent(
    authRootComponent: AuthRootComponent
) {
    Children(
        stack = authRootComponent.stack,
        modifier = Modifier.fillMaxSize()
    ) {
        when (val child = it.instance) {
            is AuthRootComponent.Child.Auth -> AuthScreen(child.authComponent)
        }
    }
}
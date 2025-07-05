package ru.dezerom.tasktracker.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import ru.dezerom.tasktracker.auth.ui.navigation.AuthRootContent

@Composable
fun RootContent(rootComponent: RootComponent) {
    Children(
        stack = rootComponent.stack,
        animation = stackAnimation(animator = slide()),
        modifier = Modifier.fillMaxSize()
    ) {
        when (val child = it.instance) {
            is RootComponent.RootChild.AuthRoot -> AuthRootContent(child.authRootComponent)
        }
    }
}
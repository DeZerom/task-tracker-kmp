package ru.dezerom.tasktracker.auth.ui.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import ru.dezerom.tasktracker.auth.ui.auth.AuthComponent
import ru.dezerom.tasktracker.auth.ui.auth.DefaultAuthComponent

interface AuthRootComponent {
    val stack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class Auth(val authComponent: AuthComponent): Child
    }
}

class DefaultAuthRootComponent(
    componentContext: ComponentContext
): AuthRootComponent, ComponentContext by componentContext {
    private val authNavigation = StackNavigation<AuthConfig>()

    override val stack: Value<ChildStack<*, AuthRootComponent.Child>> = childStack(
        source = authNavigation,
        serializer = AuthConfig.serializer(),
        initialConfiguration = AuthConfig.Auth,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(config: AuthConfig, componentContext: ComponentContext) = when (config) {
        AuthConfig.Auth -> AuthRootComponent.Child.Auth(DefaultAuthComponent(componentContext))
    }

    @Serializable
    private sealed interface AuthConfig {
         @Serializable
         data object Auth : AuthConfig
    }
}
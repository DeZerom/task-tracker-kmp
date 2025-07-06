package ru.dezerom.tasktracker.auth.ui.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import ru.dezerom.tasktracker.auth.ui.auth.AuthComponent
import ru.dezerom.tasktracker.auth.ui.registration.RegistrationComponent

interface AuthRootComponent {
    val stack: Value<ChildStack<*, Child>>

    sealed class Child {
        internal class Auth(val authComponent: AuthComponent): Child()
        internal class Registration(val registrationComponent: RegistrationComponent): Child()
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
        AuthConfig.Auth -> createAuthComponent(componentContext)
        AuthConfig.Registration -> createRegistrationComponent(componentContext)
    }

    private fun createAuthComponent(componentContext: ComponentContext): AuthRootComponent.Child {
        return AuthRootComponent.Child.Auth(
            authComponent = AuthComponent(
                componentContext = componentContext,
                onAuthorized = {},
                onCreateAccountClicked = { authNavigation.pushNew(AuthConfig.Registration) }
            )
        )
    }

    private fun createRegistrationComponent(componentContext: ComponentContext): AuthRootComponent.Child {
        return AuthRootComponent.Child.Registration(
            registrationComponent = RegistrationComponent(
                componentContext = componentContext,
                onFinished = { authNavigation.pop() }
            )
        )
    }

    @Serializable
    private sealed interface AuthConfig {
         @Serializable
         data object Auth : AuthConfig

        @Serializable
        data object Registration : AuthConfig
    }
}
package ru.dezerom.tasktracker.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import ru.dezerom.tasktracker.auth.ui.navigation.AuthRootComponent
import ru.dezerom.tasktracker.auth.ui.navigation.DefaultAuthRootComponent

interface RootComponent {
    val stack: Value<ChildStack<*, RootChild>>

    sealed interface RootChild {
        class AuthRoot(val authRootComponent: AuthRootComponent): RootChild

    }
}

class DefaultRootComponent(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {
    private val rootNavigation = StackNavigation<RootConfig>()

    override val stack: Value<ChildStack<*, RootComponent.RootChild>> = childStack(
        source = rootNavigation,
        serializer = RootConfig.serializer(),
        initialConfiguration = RootConfig.Authorization,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(config: RootConfig, componentContext: ComponentContext) =
        when (config) {
            RootConfig.Authorization ->
                RootComponent.RootChild.AuthRoot(DefaultAuthRootComponent(componentContext))
        }

    @Serializable
    private sealed interface RootConfig {
        @Serializable
        data object Authorization : RootConfig
    }
}
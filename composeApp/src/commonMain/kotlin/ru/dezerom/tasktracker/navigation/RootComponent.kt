package ru.dezerom.tasktracker.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import ru.dezerom.tasktracker.auth.ui.navigation.AuthRootComponent
import ru.dezerom.tasktracker.auth.ui.navigation.DefaultAuthRootComponent
import ru.dezerom.tasktracker.navigation.RootComponent.RootChild.AuthRoot
import ru.dezerom.tasktracker.navigation.RootComponent.RootChild.TaskListRoot
import ru.dezerom.tasktracker.taskList.ui.navigation.DefaultTasksListRootComponent
import ru.dezerom.tasktracker.taskList.ui.navigation.TaskListRootComponent

interface RootComponent {
    val stack: Value<ChildStack<*, RootChild>>

    sealed interface RootChild {
        class AuthRoot(val authRootComponent: AuthRootComponent): RootChild
        class TaskListRoot(val taskListRootComponent: TaskListRootComponent): RootChild
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
                AuthRoot(
                    DefaultAuthRootComponent(
                        componentContext = componentContext,
                        onAuthorized = { rootNavigation.replaceAll(RootConfig.TaskList) }
                    )
                )
            RootConfig.TaskList ->
                TaskListRoot(DefaultTasksListRootComponent(componentContext))
        }

    @Serializable
    private sealed interface RootConfig {
        @Serializable
        data object Authorization : RootConfig

        @Serializable
        data object TaskList : RootConfig
    }
}
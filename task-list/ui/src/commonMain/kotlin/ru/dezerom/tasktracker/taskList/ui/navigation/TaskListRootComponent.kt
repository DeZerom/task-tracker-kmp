package ru.dezerom.tasktracker.taskList.ui.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent

interface TaskListRootComponent {
    val stack: Value<ChildStack<*, Child>>

    sealed class Child {
        internal class TaskList(): Child()
    }
}

class DefaultTasksListRootComponent(
    componentContext: ComponentContext
): TaskListRootComponent, ComponentContext by componentContext, KoinComponent {
    private val taskListStack = StackNavigation<TaskListConfig>()

    override val stack: Value<ChildStack<*, TaskListRootComponent.Child>> = childStack(
        source = taskListStack,
        serializer = TaskListConfig.serializer(),
        initialConfiguration = TaskListConfig.TaskList,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(config: TaskListConfig, componentContext: ComponentContext) = when (config) {
        TaskListConfig.TaskList -> createTaskList(componentContext)
    }

    private fun createTaskList(componentContext: ComponentContext): TaskListRootComponent.Child {
        return TaskListRootComponent.Child.TaskList()
    }

    @Serializable
    private sealed interface TaskListConfig {
        @Serializable
        data object TaskList : TaskListConfig
    }
}
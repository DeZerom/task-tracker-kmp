package ru.dezerom.tasktracker.taskList.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import ru.dezerom.tasktracker.taskList.ui.taskList.TasksList

@Composable
fun TaskListRootContent(
    taskListRootComponent: TaskListRootComponent
) {
    Children(
        stack = taskListRootComponent.stack,
        modifier = Modifier.fillMaxSize()
    ) {
        when (val child = it.instance) {
            is TaskListRootComponent.Child.TaskList -> TasksList()
        }
    }
}
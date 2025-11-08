package ru.dezerom.tasktracker.taskList.ui.taskList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import ru.dezerom.tasktracker.core.resources.Res
import ru.dezerom.tasktracker.core.resources.tasks_list_add_task
import ru.dezerom.tasktracker.core.resources.tasks_list_no_tasks
import ru.dezerom.tasktracker.core.resources.tasks_list_tasks
import ru.dezerom.tasktracker.core.ui.customScaffold.AffectScaffold
import ru.dezerom.tasktracker.core.ui.customScaffold.TopBarState
import ru.dezerom.tasktracker.core.ui.kit.buttons.AccentExpandableFAB
import ru.dezerom.tasktracker.core.ui.tools.isScrolledToBottom
import ru.dezerom.tasktracker.core.ui.widgets.DefaultErrorComponent
import ru.dezerom.tasktracker.core.ui.widgets.DefaultLoaderComponent
import ru.dezerom.tasktracker.core.ui.widgets.EmptyList
import ru.dezerom.tasktracker.taskList.ui.taskList.widgets.TaskCard

@Composable
fun TasksListScreen(
) {
    TasksListContent(
        state = TasksListContract.State.Loaded(
            tasks = emptyList(),
            isRefreshing = false,
        ),
        onAddClicked = {},
        onTryAgainClicked = {},
        onRefresh = {},
        onChangeCompleteStatus = {},
        onEditClicked = {},
        onDeleteClicked = {},
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TasksListContent(
    state: TasksListContract.State,
    onAddClicked: () -> Unit,
    onTryAgainClicked: () -> Unit,
    onRefresh: () -> Unit,
    onChangeCompleteStatus: (String) -> Unit,
    onEditClicked: (String) -> Unit,
    onDeleteClicked: (String) -> Unit
) {
    val listState = rememberLazyListState()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    AffectScaffold(
        topBarState = TopBarState.TopLevel(
            title = stringResource(Res.string.tasks_list_tasks),
            scrollBehavior = scrollBehavior
        ),
        fab = {
            if (state is TasksListContract.State.Loaded) {
                AccentExpandableFAB(
                    onClick = onAddClicked,
                    icon = Icons.Default.Add,
                    expandedText = stringResource(Res.string.tasks_list_add_task),
                    isExpanded = isScrolledToBottom(listState = listState)
                )
            }
        }
    ) {
        when (state) {
            TasksListContract.State.Loading -> {
                DefaultLoaderComponent()
            }
            is TasksListContract.State.Error -> {
                DefaultErrorComponent(
                    err = state.error,
                    onTryAgain = onTryAgainClicked
                )
            }
            is TasksListContract.State.Loaded -> {
                PullToRefreshBox(
                    isRefreshing = state.isRefreshing,
                    onRefresh = onRefresh
                ) {
                    if (state.tasks.isEmpty()) {
                        EmptyList(title = stringResource(Res.string.tasks_list_no_tasks))
                    } else {
                        List(
                            state = state,
                            listState = listState,
                            scrollBehavior = scrollBehavior,
                            onChangeCompleteStatus = onChangeCompleteStatus,
                            onEditClicked = onEditClicked,
                            onDeleteClicked = onDeleteClicked
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun List(
    state: TasksListContract.State.Loaded,
    listState: LazyListState,
    scrollBehavior: TopAppBarScrollBehavior,
    onChangeCompleteStatus: (String) -> Unit,
    onEditClicked: (String) -> Unit,
    onDeleteClicked: (String) -> Unit,

) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .padding(horizontal = 16.dp)
    ) {
        items(
            count = state.tasks.size,
            key = { i -> state.tasks[i].task.id }
        ) { i ->
            val task = state.tasks[i]

            TaskCard(
                task.task,
                isLoading = task.isLoading,
                onChangeCompleteStatus = { onChangeCompleteStatus(task.task.id) },
                onEditClicked = { onEditClicked(task.task.id) },
                onDeleteClicked = { onDeleteClicked(task.task.id) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = if (i == 0) 16.dp else 0.dp,
                        bottom = if (i >= state.tasks.size - 1)
                            16.dp * 2 + 56.dp
                        else
                            0.dp
                    )
            )
        }
    }
}
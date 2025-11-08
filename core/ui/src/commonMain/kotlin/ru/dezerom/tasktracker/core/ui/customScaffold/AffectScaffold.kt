package ru.dezerom.tasktracker.core.ui.customScaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier

@Composable
fun AffectScaffold(
    modifier: Modifier = Modifier,
    topBarState: TopBarState = TopBarState.NoTopBar,
    fab: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    LaunchedEffect(topBarState, fab) {
        if (topBarState != CustomScaffoldStateHolder.state.value.topBarState) {
            CustomScaffoldStateHolder.reduceState { copy(topBarState = topBarState) }
        }

        if (fab != CustomScaffoldStateHolder.state.value.fab) {
            CustomScaffoldStateHolder.reduceState { copy(fab = fab) }
        }
    }

    Box(modifier) {
        content()
    }
}
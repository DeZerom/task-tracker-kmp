package ru.dezerom.tasktracker.customScaffold

import androidx.compose.runtime.Composable

data class CustomScaffoldState(
    val topBarState: TopBarState = TopBarState.NoTopBar,
    val mainNavState: MainNavState = MainNavState.NoMainNav,
    val fab: @Composable () -> Unit = {},
)

sealed class TopBarState {
    object NoTopBar : TopBarState()
}

sealed class MainNavState {
    object NoMainNav : MainNavState()
}
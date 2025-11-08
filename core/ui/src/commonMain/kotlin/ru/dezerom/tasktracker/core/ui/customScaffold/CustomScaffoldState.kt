package ru.dezerom.tasktracker.core.ui.customScaffold

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

data class CustomScaffoldState(
    val topBarState: TopBarState = TopBarState.NoTopBar,
    val mainNavState: MainNavState = MainNavState.NoMainNav,
    val fab: @Composable () -> Unit = {},
)

sealed class TopBarState {
    object NoTopBar : TopBarState()

    @OptIn(ExperimentalMaterial3Api ::class)
    class TopLevel(val title: String, val scrollBehavior: TopAppBarScrollBehavior) : TopBarState()
}

sealed class MainNavState {
    object NoMainNav : MainNavState()
}
package ru.dezerom.tasktracker.core.ui.customScaffold

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import ru.dezerom.tasktracker.core.ui.kit.topBar.TopLevelTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomScaffoldTopBar(
    topBarState: TopBarState
) {
    when (topBarState) {
        TopBarState.NoTopBar -> Unit
        is TopBarState.TopLevel -> {
            TopLevelTopBar(title = topBarState.title, scrollBehavior = topBarState.scrollBehavior)
        }
    }
}
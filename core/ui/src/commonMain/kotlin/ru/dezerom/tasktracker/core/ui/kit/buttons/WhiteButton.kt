package ru.dezerom.tasktracker.core.ui.kit.buttons

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.dezerom.tasktracker.core.ui.kit.Colors

@Composable
fun WhiteButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    testTag: String = "",
) {
    BaseButton(
        onClick = onClick,
        text = text,
        textColor = Colors.darkSurface,
        backgroundColor = Colors.white,
        modifier = modifier,
        isLoading = isLoading,
        testTag = testTag,
    )
}
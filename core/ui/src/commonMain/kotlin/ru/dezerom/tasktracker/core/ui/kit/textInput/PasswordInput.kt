package ru.dezerom.tasktracker.core.ui.kit.textInput

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun PasswordInput(
    value: String,
    labelText: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    error: String? = null,
) {
    TextInput(
        value = value,
        onValueChanged = onValueChanged,
        labelText = labelText,
        isError = isError,
        error = error,
        visualTransformation = PasswordVisualTransformation('*'),
        modifier = modifier,
    )
}
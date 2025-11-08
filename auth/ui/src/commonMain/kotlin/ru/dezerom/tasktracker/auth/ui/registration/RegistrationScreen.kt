package ru.dezerom.tasktracker.auth.ui.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.dezerom.tasktracker.core.resources.Res
import ru.dezerom.tasktracker.core.resources.app_icon
import ru.dezerom.tasktracker.core.resources.reg_has_account
import ru.dezerom.tasktracker.core.resources.reg_login
import ru.dezerom.tasktracker.core.resources.reg_password
import ru.dezerom.tasktracker.core.resources.reg_register
import ru.dezerom.tasktracker.core.resources.reg_registration
import ru.dezerom.tasktracker.core.ui.kit.Colors
import ru.dezerom.tasktracker.core.ui.kit.TS
import ru.dezerom.tasktracker.core.ui.kit.buttons.WhiteButton
import ru.dezerom.tasktracker.core.ui.kit.textInput.PasswordInput
import ru.dezerom.tasktracker.core.ui.kit.textInput.TextInput
import ru.dezerom.tasktracker.core.ui.kit.theme.TaskTrackerTheme
import ru.dezerom.tasktracker.core.ui.tools.LocalWindowSize
import ru.dezerom.tasktracker.core.ui.tools.getString
import ru.dezerom.tasktracker.core.ui.tools.size.singleElementWidth
import ru.dezerom.tasktracker.core.ui.widgets.VSpacer

@Composable
internal fun RegistrationScreen(
    component: RegistrationComponent
) {
    val state by component.state.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        RegistrationContent(
            state = state,
            onEvent = component::consumeEvent,
        )
    }
}

@Composable
internal fun RegistrationContent(
    state: RegistrationContract.State,
    onEvent: (RegistrationContract.Event) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .imePadding()
            .singleElementWidth(LocalWindowSize.current)
            .padding(all = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(resource = Res.drawable.app_icon),
            contentDescription = null,
        )
        VSpacer(height = 24.dp)
        Text(
            stringResource(resource = Res.string.reg_registration),
            style = TS.titleLarge
        )
        VSpacer(height = 36.dp)
        TextInput(
            value = state.login,
            labelText = stringResource(resource = Res.string.reg_login),
            isError = state.loginError != null,
            error = state.loginError?.getString(),
            onValueChanged = { onEvent(RegistrationContract.Event.LoginChanged(it)) },
            modifier = Modifier.fillMaxWidth(),
        )
        VSpacer(height = 16.dp)
        PasswordInput(
            value = state.password,
            labelText = stringResource(resource = Res.string.reg_password),
            isError = state.passwordError != null,
            error = state.passwordError?.getString(),
            onValueChanged = { onEvent(RegistrationContract.Event.PasswordChanged(it)) },
            modifier = Modifier.fillMaxWidth(),
        )
        VSpacer(height = 8.dp)
        Text(
            text = stringResource(resource = Res.string.reg_has_account),
            color = Colors.secondaryText,
            style = TS.bodySmall,
            modifier = Modifier
                .align(Alignment.Start)
                .clickable { onEvent(RegistrationContract.Event.HasAccountClicked) }
        )
        VSpacer(height = 48.dp)
        WhiteButton(
            onClick = { onEvent(RegistrationContract.Event.OnRegisterClicked) },
            text = stringResource(resource = Res.string.reg_register),
            isLoading = state.isLoading,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
@Preview
private fun RegistrationPreview() {
    TaskTrackerTheme {
        RegistrationContent(
            state = RegistrationContract.State(),
            onEvent = {}
        )
    }
}

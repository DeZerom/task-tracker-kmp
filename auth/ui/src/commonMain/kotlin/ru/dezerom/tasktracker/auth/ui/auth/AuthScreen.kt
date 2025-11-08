package ru.dezerom.tasktracker.auth.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
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
import ru.dezerom.tasktracker.core.resources.auth_authorization
import ru.dezerom.tasktracker.core.resources.auth_authorize
import ru.dezerom.tasktracker.core.resources.auth_create_account
import ru.dezerom.tasktracker.core.resources.auth_login
import ru.dezerom.tasktracker.core.resources.auth_password
import ru.dezerom.tasktracker.core.ui.customScaffold.AffectScaffold
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
internal fun AuthScreen(
    authComponent: AuthComponent
) {
    val state by authComponent.state.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (state.isInitializing) {
            AuthScreenInit()
        } else {
            AuthScreenContent(
                onEvent = authComponent::consumeEvent,
                state = state,
            )
        }
    }
}

@Composable
private fun AuthScreenInit() {
    Scaffold { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Image(
                painter = painterResource(resource = Res.drawable.app_icon),
                contentDescription = null,
                modifier = Modifier.size(192.dp)
            )
        }
    }
}

@Composable
private fun AuthScreenContent(
    onEvent: (AuthContract.AuthScreenEvent) -> Unit,
    state: AuthContract.AuthScreenState,
) {
    AffectScaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .imePadding()
                .singleElementWidth(LocalWindowSize.current)
                .padding(all = 16.dp)
        ) {
            Image(
                painter = painterResource(resource = Res.drawable.app_icon),
                contentDescription = null,
            )
            VSpacer(height = 24.dp)
            Text(
                stringResource(resource = Res.string.auth_authorization),
                style = TS.titleLarge
            )
            VSpacer(height = 36.dp)
            TextInput(
                value = state.login,
                labelText = stringResource(resource = Res.string.auth_login),
                isError = state.loginError != null,
                error = state.loginError?.getString(),
                onValueChanged = { onEvent(AuthContract.AuthScreenEvent.LoginChanged(it)) },
                modifier = Modifier.fillMaxWidth(),
            )
            VSpacer(height = 16.dp)
            PasswordInput(
                value = state.password,
                labelText = stringResource(resource = Res.string.auth_password),
                isError = state.passwordError != null,
                error = state.passwordError?.getString(),
                onValueChanged = { onEvent(AuthContract.AuthScreenEvent.PasswordChanged(it)) },
                modifier = Modifier.fillMaxWidth(),
            )
            VSpacer(height = 8.dp)
            Text(
                text = stringResource(resource = Res.string.auth_create_account),
                color = Colors.secondaryText,
                style = TS.bodySmall,
                modifier = Modifier
                    .align(Alignment.Start)
                    .clickable { onEvent(AuthContract.AuthScreenEvent.OnCreateAccClicked) }
            )
            VSpacer(height = 48.dp)
            WhiteButton(
                onClick = { onEvent(AuthContract.AuthScreenEvent.OnAuthorizeClicked) },
                text = stringResource(resource = Res.string.auth_authorize),
                isLoading = state.isLoading,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
@Preview
private fun AuthScreenPreview() {
    TaskTrackerTheme {
        AuthScreenContent(
            onEvent = {},
            state = AuthContract.AuthScreenState(),
        )
    }
}
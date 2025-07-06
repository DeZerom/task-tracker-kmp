package ru.dezerom.tasktracker.auth.ui.auth

import androidx.compose.runtime.Immutable
import ru.dezerom.tasktracker.core.tools.stringContainer.StringContainer

internal class AuthContract {
    @Immutable
    internal data class AuthScreenState(
        val isLoading: Boolean = false,
        val login: String = "",
        val password: String = "",
        val loginError: StringContainer? = null,
        val passwordError: StringContainer? = null,
        val isInitializing: Boolean = false
    )

    internal sealed class AuthScreenEvent {
        class LoginChanged(val newLogin: String): AuthScreenEvent()
        class PasswordChanged(val newPassword: String): AuthScreenEvent()
        data object OnCreateAccClicked: AuthScreenEvent()
        data object OnAuthorizeClicked: AuthScreenEvent()
    }

    sealed class AuthScreenSideEffect
}
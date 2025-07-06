package ru.dezerom.tasktracker.auth.ui.registration

import androidx.compose.runtime.Immutable
import ru.dezerom.tasktracker.core.tools.stringContainer.StringContainer

class RegistrationContract {
    @Immutable
    internal data class State(
        val login: String = "",
        val password: String = "",
        val loginError: StringContainer? = null,
        val passwordError: StringContainer? = null,
        val isLoading: Boolean = false,
    )

    sealed class Event {
        class LoginChanged(val newLogin: String): Event()
        class PasswordChanged(val newPassword: String): Event()
        object OnRegisterClicked: Event()
        object HasAccountClicked: Event()
    }

    sealed class SideEffect
}
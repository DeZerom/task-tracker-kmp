package ru.dezerom.tasktracker.auth.ui.auth

import com.arkivanov.decompose.ComponentContext
import ru.dezerom.tasktracker.auth.ui.auth.AuthContract.AuthScreenEvent
import ru.dezerom.tasktracker.auth.ui.auth.AuthContract.AuthScreenSideEffect
import ru.dezerom.tasktracker.auth.ui.auth.AuthContract.AuthScreenState
import ru.dezerom.tasktracker.core.resources.Res
import ru.dezerom.tasktracker.core.resources.err_field_must_not_be_empty
import ru.dezerom.tasktracker.core.tools.stringContainer.StringContainer
import ru.dezerom.tasktracker.core.ui.decompose.BaseComponent

internal class AuthComponent(
    componentContext: ComponentContext,
    private val onAuthorized: () -> Unit,
    private val onCreateAccountClicked: () -> Unit
) : BaseComponent<AuthScreenState, AuthScreenEvent, AuthScreenSideEffect>(componentContext) {
    override fun initState(): AuthScreenState = AuthScreenState()

    override suspend fun handleEvent(event: AuthScreenEvent) {
        when (event) {
            is AuthScreenEvent.LoginChanged -> onLoginChanged(event.newLogin)
            is AuthScreenEvent.PasswordChanged -> onPasswordChanged(event.newPassword)
            AuthScreenEvent.OnAuthorizeClicked -> onAuthorizeClicked()
            AuthScreenEvent.OnCreateAccClicked -> createAccountClicked()
        }
    }

    private fun createAccountClicked() = onCreateAccountClicked()

    private fun onLoginChanged(login: String) {
        reduceState {
            copy(
                login = login,
                loginError = if (login.isNotBlank())
                    null
                else
                    StringContainer.StringRes(Res.string.err_field_must_not_be_empty),
            )
        }
    }

    private fun onPasswordChanged(password: String) {
        reduceState {
            copy(
                password = password,
                passwordError = if (password.isNotBlank())
                    null
                else
                    StringContainer.StringRes(Res.string.err_field_must_not_be_empty),
            )
        }
    }

    private suspend fun onAuthorizeClicked() {
        if (state.value.isLoading) return

        if (!validate()) return

        reduceState { copy(isLoading = true) }

//        val result = authInteractor.authorize(
//            login = state.value.login,
//            pass = state.value.password
//        )

//        result.fold(
//            onSuccess = {
//                if (it) {
//                    _sideEffects.send(AuthScreenSideEffect.GoToTasks)
//                } else {
//                    showError(R.string.unknown_error.toStringContainer())
//                }
//            },
//            onFailure = {
//                showError(it)
//            }
//        )

        reduceState { copy(isLoading = false) }
    }

    private fun validate(): Boolean {
        val s = state.value
        val res = s.login.isNotBlank() && s.password.isNotBlank()

        if (!res) {
            val error = StringContainer.StringRes(Res.string.err_field_must_not_be_empty)

            reduceState {
                copy(
                    loginError = if (s.login.isBlank()) error else null,
                    passwordError = if (s.password.isBlank()) error else null
                )
            }
        }

        return res
    }
}
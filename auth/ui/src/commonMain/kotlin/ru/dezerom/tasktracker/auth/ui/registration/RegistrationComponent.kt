package ru.dezerom.tasktracker.auth.ui.registration

import com.arkivanov.decompose.ComponentContext
import ru.dezerom.tasktracker.auth.ui.registration.RegistrationContract.Event
import ru.dezerom.tasktracker.auth.ui.registration.RegistrationContract.SideEffect
import ru.dezerom.tasktracker.auth.ui.registration.RegistrationContract.State
import ru.dezerom.tasktracker.core.resources.Res
import ru.dezerom.tasktracker.core.resources.err_field_must_not_be_empty
import ru.dezerom.tasktracker.core.tools.stringContainer.wrapInContainer
import ru.dezerom.tasktracker.core.ui.decompose.BaseComponent

internal class RegistrationComponent(
    componentContext: ComponentContext,
    private val onFinished: () -> Unit
) : BaseComponent<State, Event, SideEffect>(componentContext) {
    override fun initState(): State = State()

    override suspend fun handleEvent(event: Event) {
        when (event) {
            is Event.LoginChanged -> onLoginChanged(event.newLogin)
            is Event.PasswordChanged -> onPasswordChanged(event.newPassword)
            Event.OnRegisterClicked -> onRegisterClicked()
            Event.HasAccountClicked -> onFinished()
        }
    }

    private fun onLoginChanged(newLogin: String) {
        reduceState {
            copy(
                login = newLogin,
                loginError = if (newLogin.isBlank())
                    Res.string.err_field_must_not_be_empty.wrapInContainer()
                else
                    null
            )
        }
    }

    private fun onPasswordChanged(newPassword: String) {
        reduceState {
            copy(
                password = newPassword,
                passwordError = if (newPassword.isBlank())
                    Res.string.err_field_must_not_be_empty.wrapInContainer()
                else
                    null
            )
        }
    }

    private suspend fun onRegisterClicked() {
        if (state.value.isLoading) return

        if (!validateData()) return

        reduceState { copy(isLoading = true) }

        val s = state.value

//        authInteractor.register(s.login, s.password).fold(
//            onSuccess = {
//                if (it) {
//                    launch {
//                        showSuccess(R.string.success_reg.toStringContainer())
//                        delay(500)
//                        _sideEffects.send(RegistrationScreenSideEffect.GoBack)
//                    }
//                } else {
//                    showError(R.string.unknown_error.toStringContainer())
//                }
//            },
//            onFailure = { showError(it) }
//        )

        reduceState { copy(isLoading = false) }
    }

    private fun validateData(): Boolean {
        var s = state.value
        var res = true

        if (s.login.isEmpty()) {
            res = false
            s = s.copy(loginError = Res.string.err_field_must_not_be_empty.wrapInContainer())
        }

        if (s.password.isEmpty()) {
            res = false
            s = s.copy(passwordError = Res.string.err_field_must_not_be_empty.wrapInContainer())
        }

        if (!res) setState(s)

        return res
    }
}
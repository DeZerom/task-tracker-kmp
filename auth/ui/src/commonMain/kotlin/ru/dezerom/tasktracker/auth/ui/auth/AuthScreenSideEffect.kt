package ru.dezerom.tasktracker.auth.ui.auth

sealed class AuthScreenSideEffect {
    data object GoToRegistration: AuthScreenSideEffect()

    data object GoToTasks: AuthScreenSideEffect()
}

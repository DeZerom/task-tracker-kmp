package ru.dezerom.tasktracker.auth.ui.auth

import com.arkivanov.decompose.ComponentContext

interface AuthComponent {

}

class DefaultAuthComponent(
    componentContext: ComponentContext
) : AuthComponent, ComponentContext by componentContext {

}
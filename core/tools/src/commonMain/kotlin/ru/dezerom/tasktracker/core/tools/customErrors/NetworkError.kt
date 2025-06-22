package ru.dezerom.tasktracker.core.tools.customErrors

import ru.dezerom.tasktracker.core.tools.stringContainer.StringContainer

class NetworkError(val messageRes: StringContainer): Exception()
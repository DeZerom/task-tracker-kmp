package ru.dezerom.tasktracker.core.tools.customErrors

import ru.dezerom.tasktracker.core.resources.Res
import ru.dezerom.tasktracker.core.resources.err_unauthorized_error
import ru.dezerom.tasktracker.core.resources.err_unknown_error
import ru.dezerom.tasktracker.core.tools.stringContainer.StringContainer
import ru.dezerom.tasktracker.core.tools.stringContainer.wrapInContainer

class NetworkError(val messageRes: StringContainer): Exception() {
    companion object {
        fun unknownNetworkError() = NetworkError(Res.string.err_unknown_error.wrapInContainer())
        fun unauthorizedNetworkError() = NetworkError(Res.string.err_unauthorized_error.wrapInContainer())
    }
}
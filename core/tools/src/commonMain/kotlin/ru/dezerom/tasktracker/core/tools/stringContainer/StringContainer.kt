package ru.dezerom.tasktracker.core.tools.stringContainer

import org.jetbrains.compose.resources.StringResource

sealed interface StringContainer {

    class StringRes(val res: StringResource): StringContainer

    class RawString(val str: String): StringContainer
}

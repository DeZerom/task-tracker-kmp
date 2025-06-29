package ru.dezerom.tasktracker.core.tools.stringContainer

import org.jetbrains.compose.resources.StringResource

fun String.wrapInContainer(): StringContainer {
    return StringContainer.RawString(this)
}

fun StringResource.wrapInContainer(): StringContainer {
    return StringContainer.StringRes(this)
}
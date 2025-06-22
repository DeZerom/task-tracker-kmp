package ru.dezerom.tasktracker.core.tools.stringContainer

sealed interface StringContainer {

    class StringRes(val res: Int): StringContainer

    class RawString(val str: String): StringContainer
}

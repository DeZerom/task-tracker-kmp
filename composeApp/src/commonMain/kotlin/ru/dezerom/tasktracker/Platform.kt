package ru.dezerom.tasktracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
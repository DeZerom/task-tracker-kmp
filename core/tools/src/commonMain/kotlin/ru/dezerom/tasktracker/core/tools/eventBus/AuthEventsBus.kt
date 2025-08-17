package ru.dezerom.tasktracker.core.tools.eventBus

class AuthEventsBus : BaseEventBus<UnauthorizedEvent>()

object UnauthorizedEvent
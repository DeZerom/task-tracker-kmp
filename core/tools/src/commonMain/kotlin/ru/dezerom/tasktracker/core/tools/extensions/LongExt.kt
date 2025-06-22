package ru.dezerom.tasktracker.core.tools.extensions

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime

fun Long.toDayMonthYear(): String {
    val instant = Instant.fromEpochMilliseconds(this)
    val date = instant.toLocalDateTime(TimeZone.currentSystemDefault())
    val format = LocalDateTime.Format {
        dayOfMonth()
        char('.')
        monthNumber()
        char('.')
        year()
    }

    return format.format(date)
}

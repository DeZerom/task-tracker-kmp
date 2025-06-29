package ru.dezerom.tasktracker.core.data.cache.datastoreCreator

import android.content.Context

fun createDatastore(context: Context) = createDatastore {
    context.filesDir.resolve(datastoreFileName).absolutePath
}
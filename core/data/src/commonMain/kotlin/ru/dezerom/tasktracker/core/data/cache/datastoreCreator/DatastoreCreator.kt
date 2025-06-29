package ru.dezerom.tasktracker.core.data.cache.datastoreCreator

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

fun createDatastore(producePath: () -> String): DataStore<Preferences> {
    return PreferenceDataStoreFactory.createWithPath {
        producePath().toPath()
    }
}

internal val datastoreFileName = "tasktracker.preference_db"
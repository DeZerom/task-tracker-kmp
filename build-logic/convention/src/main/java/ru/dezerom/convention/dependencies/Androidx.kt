package ru.dezerom.convention.dependencies

import org.gradle.api.artifacts.VersionCatalog

val VersionCatalog.androidxDatastore get() =
    findLibrary("androidx-datastore").get()

val VersionCatalog.androidxDatastorePreferences get() =
    findLibrary("androidx-datastorePreferences").get()

val VersionCatalog.androidxActivityCompose get() =
    findLibrary("androidx-activity-compose").get()
package ru.dezerom.convention.dependencies

import org.gradle.api.artifacts.VersionCatalog

internal val VersionCatalog.kotlinxCoroutines get() =
    findLibrary("kotlinx-coroutines-core").get()

internal val VersionCatalog.kotlinxDateTime get() =
    findLibrary("kotlinx-dateTime").get()

internal val VersionCatalog.kotlinxSerializationJson get() =
    findLibrary("kotlinx-serializationJson").get()
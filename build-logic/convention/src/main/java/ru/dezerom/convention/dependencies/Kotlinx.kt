package ru.dezerom.convention.dependencies

import org.gradle.api.artifacts.VersionCatalog
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

internal val VersionCatalog.kotlinxCoroutines get() =
    findLibrary("kotlinx-coroutines-core").get()

internal val VersionCatalog.kotlinxDateTime get() =
    findLibrary("kotlinx-dateTime").get()

internal val VersionCatalog.kotlinxSerializationJson get() =
    findLibrary("kotlinx-serializationJson").get()
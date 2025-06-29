package ru.dezerom.convention.dependencies

import org.gradle.api.artifacts.VersionCatalog
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

val VersionCatalog.kotlinxCoroutines get() =
    findLibrary("kotlinx-coroutines-core").get()

val VersionCatalog.kotlinxDateTime get() =
    findLibrary("kotlinx-dateTime").get()

val VersionCatalog.kotlinxSerializationJson get() =
    findLibrary("kotlinx-serializationJson").get()
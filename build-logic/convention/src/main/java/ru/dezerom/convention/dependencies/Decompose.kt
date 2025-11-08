package ru.dezerom.convention.dependencies

import org.gradle.api.artifacts.VersionCatalog

val VersionCatalog.decompose get() =
    findLibrary("arkivanov-decompose").get()

val VersionCatalog.decomposeComposeExtensions get() =
    findLibrary("arkivanov-decomposeComposeExtensions").get()

val VersionCatalog.essenty get() =
    findLibrary("arkivanov-essenty-coroutines").get()

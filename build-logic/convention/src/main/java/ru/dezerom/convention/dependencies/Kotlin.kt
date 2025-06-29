package ru.dezerom.convention.dependencies

import org.gradle.api.artifacts.VersionCatalog

internal val VersionCatalog.kotlin get() =
    findLibrary("kotlin-stdlib").get()

internal val VersionCatalog.kotlinTest get() =
    findLibrary("kotlin-test").get()
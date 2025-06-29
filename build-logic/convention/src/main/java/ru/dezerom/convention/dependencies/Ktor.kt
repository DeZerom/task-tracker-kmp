package ru.dezerom.convention.dependencies

import org.gradle.api.artifacts.VersionCatalog

internal val VersionCatalog.ktorClient get() =
    findLibrary("ktorClient").get()
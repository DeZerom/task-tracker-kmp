package ru.dezerom.convention.dependencies

import org.gradle.api.artifacts.VersionCatalog

internal val VersionCatalog.ktorClient get() =
    findLibrary("ktor-client-core").get()

internal val VersionCatalog.ktorClientCio get() =
    findLibrary("ktor-client-cio").get()
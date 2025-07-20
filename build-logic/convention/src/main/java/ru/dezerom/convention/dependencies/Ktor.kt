package ru.dezerom.convention.dependencies

import org.gradle.api.artifacts.VersionCatalog

internal val VersionCatalog.ktorClientCore get() =
    findLibrary("ktor-client-core").get()

internal val VersionCatalog.ktorClientCio get() =
    findLibrary("ktor-client-cio").get()

internal val VersionCatalog.ktorClientContentNegotiation get() =
    findLibrary("ktor-client-contentNegotiation").get()

internal val VersionCatalog.ktorClientSerializationJson get() =
    findLibrary("ktor-client-serializationJson").get()
package ru.dezerom.convention.dependencies

import org.gradle.api.artifacts.VersionCatalog

internal val VersionCatalog.logging get() =
    findLibrary("diamondEdge-logging").get()
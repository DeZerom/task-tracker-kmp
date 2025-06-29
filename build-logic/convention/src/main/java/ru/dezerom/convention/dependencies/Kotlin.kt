package ru.dezerom.convention.dependencies

import org.gradle.api.artifacts.VersionCatalog
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import ru.dezerom.convention.utils.libs

internal val VersionCatalog.kotlin get() =
    findLibrary("kotlin-stdlib").get()

internal val VersionCatalog.kotlinTest get() =
    findLibrary("kotlin-test").get()
package ru.dezerom.convention.dependencies

import org.gradle.api.artifacts.VersionCatalog
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import ru.dezerom.convention.utils.libs

val VersionCatalog.kotlin get() =
    findLibrary("kotlin-stdlib").get()

val VersionCatalog.kotlinTest get() =
    findLibrary("kotlin-test").get()
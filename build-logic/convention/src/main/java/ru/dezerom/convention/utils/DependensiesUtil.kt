package ru.dezerom.convention.utils

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType

val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun DependencyHandlerScope.commonMainImplementation(dependency: Any) =
    add("commonMainImplementation", dependency)

fun DependencyHandlerScope.commonTestImplementation(dependency: Any) =
    add("commonTestImplementation", dependency)

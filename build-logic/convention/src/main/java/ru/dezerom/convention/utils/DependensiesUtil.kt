package ru.dezerom.convention.utils

import org.gradle.api.NamedDomainObjectCollection
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.compose.ComposePlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

val Project.compose: ComposePlugin.Dependencies
    get() = extensions.getByType<ComposeExtension>().dependencies

val NamedDomainObjectCollection<KotlinSourceSet>.desktopMain: KotlinSourceSet
    get() = getByName("desktopMain")

fun DependencyHandlerScope.commonMainImplementation(dependency: Any) =
    add("commonMainImplementation", dependency)

fun DependencyHandlerScope.commonTestImplementation(dependency: Any) =
    add("commonTestImplementation", dependency)

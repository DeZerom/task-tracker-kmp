package ru.dezerom.convention.dependencies

import org.jetbrains.compose.ComposePlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun KotlinDependencyHandler.addComposeDependencies(compose: ComposePlugin.Dependencies) {
    implementation(compose.runtime)
    implementation(compose.foundation)
    implementation(compose.material3)
    implementation(compose.ui)
    implementation(compose.components.resources)
    implementation(compose.components.uiToolingPreview)
}
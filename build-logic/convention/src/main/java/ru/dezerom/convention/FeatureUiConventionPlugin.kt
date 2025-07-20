package ru.dezerom.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.dezerom.convention.dependencies.addComposeDependencies
import ru.dezerom.convention.dependencies.androidxActivityCompose
import ru.dezerom.convention.dependencies.composeWindowSize
import ru.dezerom.convention.dependencies.decompose
import ru.dezerom.convention.dependencies.decomposeComposeExtensions
import ru.dezerom.convention.dependencies.kotlinxCoroutinesSwing
import ru.dezerom.convention.dependencies.logging
import ru.dezerom.convention.utils.compose
import ru.dezerom.convention.utils.desktopMain
import ru.dezerom.convention.utils.kotlin
import ru.dezerom.convention.utils.libs

class FeatureUiConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("build.kmp.library")
                apply("build.koin")
                apply("org.jetbrains.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
                apply("org.jetbrains.compose.hot-reload")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            kotlin {
                sourceSets.commonMain.dependencies {
                    implementation(project(":core:resources"))
                    implementation(project(":core:tools"))
                    implementation(project(":core:ui"))

                    implementation(libs.logging)
                    implementation(libs.composeWindowSize)

                    implementation(libs.decompose)
                    implementation(libs.decomposeComposeExtensions)

                    addComposeDependencies(compose)
                }

                sourceSets.androidMain.dependencies {
                    implementation(compose.preview)
                    implementation(libs.androidxActivityCompose)
                }

                sourceSets.desktopMain.dependencies {
                    implementation(compose.desktop.currentOs)
                    implementation(libs.kotlinxCoroutinesSwing)
                }
            }
        }
    }
}
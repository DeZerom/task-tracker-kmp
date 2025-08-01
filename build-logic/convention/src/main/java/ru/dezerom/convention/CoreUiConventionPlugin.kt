package ru.dezerom.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.dezerom.convention.dependencies.addComposeDependencies
import ru.dezerom.convention.dependencies.androidxActivityCompose
import ru.dezerom.convention.dependencies.composeWindowSize
import ru.dezerom.convention.dependencies.decompose
import ru.dezerom.convention.dependencies.kotlinxCoroutinesSwing
import ru.dezerom.convention.dependencies.logging
import ru.dezerom.convention.utils.compose
import ru.dezerom.convention.utils.desktopMain
import ru.dezerom.convention.utils.kotlin
import ru.dezerom.convention.utils.libs

class CoreUiConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("build.kmp.library")
                apply("org.jetbrains.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
                apply("build.koin")
            }

            kotlin {
                sourceSets.commonMain.dependencies {
                    implementation(project(":core:resources"))
                    implementation(project(":core:tools"))

                    implementation(libs.logging)
                    implementation(libs.composeWindowSize)

                    implementation(libs.decompose)

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
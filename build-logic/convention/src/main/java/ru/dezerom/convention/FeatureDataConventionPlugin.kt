package ru.dezerom.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.dezerom.convention.dependencies.kotlinxSerializationJson
import ru.dezerom.convention.dependencies.ktorClient
import ru.dezerom.convention.dependencies.ktorClientCio
import ru.dezerom.convention.dependencies.logging
import ru.dezerom.convention.utils.kotlin
import ru.dezerom.convention.utils.libs

class FeatureDataConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("build.kmp.library")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            kotlin {
                sourceSets.commonMain.dependencies {
                    implementation(project(":core:resources"))
                    implementation(project(":core:tools"))
                    implementation(project(":core:data"))

                    implementation(libs.logging)

                    implementation(libs.kotlinxSerializationJson)

                    implementation(libs.ktorClient)
                    implementation(libs.ktorClientCio)
                }
            }
        }
    }
}
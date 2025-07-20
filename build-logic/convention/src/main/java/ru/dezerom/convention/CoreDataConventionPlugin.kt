package ru.dezerom.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.dezerom.convention.dependencies.androidxDatastore
import ru.dezerom.convention.dependencies.androidxDatastorePreferences
import ru.dezerom.convention.dependencies.kotlinxSerializationJson
import ru.dezerom.convention.dependencies.ktorClientCio
import ru.dezerom.convention.dependencies.ktorClientContentNegotiation
import ru.dezerom.convention.dependencies.ktorClientCore
import ru.dezerom.convention.dependencies.ktorClientSerializationJson
import ru.dezerom.convention.dependencies.logging
import ru.dezerom.convention.utils.kotlin
import ru.dezerom.convention.utils.libs

class CoreDataConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("build.kmp.library")
                apply("build.koin")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            kotlin {
                sourceSets.commonMain.dependencies {
                    implementation(project(":core:resources"))
                    implementation(project(":core:tools"))

                    implementation(libs.kotlinxSerializationJson)
                    implementation(libs.logging)

                    implementation(libs.ktorClientCore)
                    implementation(libs.ktorClientCio)
                    implementation(libs.ktorClientContentNegotiation)
                    implementation(libs.ktorClientSerializationJson)

                    implementation(libs.androidxDatastore)
                    implementation(libs.androidxDatastorePreferences)
                }
            }
        }
    }
}
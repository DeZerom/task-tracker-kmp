package ru.dezerom.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.dezerom.convention.dependencies.koinAndroid
import ru.dezerom.convention.dependencies.koinCompose
import ru.dezerom.convention.dependencies.koinCore
import ru.dezerom.convention.dependencies.koinTest
import ru.dezerom.convention.utils.kotlin
import ru.dezerom.convention.utils.libs

class KoinConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            kotlin {
                sourceSets.commonMain.dependencies {
                    implementation(libs.koinCore)
                    implementation(libs.koinTest)
                    implementation(libs.koinCompose)
                }

                sourceSets.androidMain.dependencies {
                    implementation(libs.koinAndroid)
                }
            }
        }
    }
}
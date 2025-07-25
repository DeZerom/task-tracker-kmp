package ru.dezerom.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.dezerom.convention.dependencies.logging
import ru.dezerom.convention.utils.kotlin
import ru.dezerom.convention.utils.libs

class FeatureDomainConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("build.kmp.library")
                apply("build.koin")
            }

            kotlin {
                sourceSets.commonMain.dependencies {
                    implementation(project(":core:resources"))
                    implementation(project(":core:tools"))

                    implementation(libs.logging)
                }
            }
        }
    }
}
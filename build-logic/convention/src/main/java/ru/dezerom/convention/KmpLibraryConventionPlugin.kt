package ru.dezerom.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import ru.dezerom.convention.dependencies.kotlin
import ru.dezerom.convention.dependencies.kotlinTest
import ru.dezerom.convention.dependencies.kotlinxCoroutines
import ru.dezerom.convention.utils.commonMainImplementation
import ru.dezerom.convention.utils.commonTestImplementation
import ru.dezerom.convention.utils.configureKotlinMultiplatform
import ru.dezerom.convention.utils.libs

class KmpLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
                apply("com.android.kotlin.multiplatform.library")
            }

            configureKotlinMultiplatform()

            dependencies {
                commonMainImplementation(libs.kotlin)
                commonMainImplementation(libs.kotlinxCoroutines)

                commonTestImplementation(libs.kotlinTest)
            }
        }
    }
}
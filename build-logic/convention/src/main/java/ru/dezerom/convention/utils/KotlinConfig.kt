package ru.dezerom.convention.utils

import com.android.build.api.dsl.androidLibrary
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@Suppress("UnstableApiUsage")
internal fun Project.configureKotlinMultiplatform() {
    extensions.configure(KotlinMultiplatformExtension::class.java) {
        androidLibrary {
            compileSdk = 35
            minSdk = 24

            withHostTestBuilder {
            }

            withDeviceTestBuilder {
                sourceSetTreeName = "test"
            }.configure {
                instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
        }

        iosSimulatorArm64()
        iosX64()
        iosArm64()
        jvm("desktop")
    }
}
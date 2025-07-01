import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "ru.dezerom.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("kmpLibrary") {
            id = "build.kmp.library"
            implementationClass = "ru.dezerom.convention.KmpLibraryConventionPlugin"
        }

        register("coreData") {
            id = "build.core.data"
            implementationClass = "ru.dezerom.convention.CoreDataConventionPlugin"
        }
        register("coreUi") {
            id = "build.core.ui"
            implementationClass = "ru.dezerom.convention.CoreUiConventionPlugin"
        }
    }
}

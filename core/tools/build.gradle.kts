plugins {
    alias(libs.plugins.build.kmpLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    androidLibrary {
        namespace = "ru.dezerom.tasktracker.core.tools"
    }

    val xcfName = "coreToolsKit"
    iosX64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.components.resources)

                implementation(libs.kotlinx.dateTime)
                implementation(projects.core.resources)
            }
        }
    }
}
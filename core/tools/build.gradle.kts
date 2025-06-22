plugins {
    alias(libs.plugins.build.kmpLibrary)
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
                implementation(libs.kotlinx.dateTime)
            }
        }
    }
}
plugins {
    alias(libs.plugins.build.feature.data)
}

kotlin {
    androidLibrary {
        namespace = "ru.dezerom.tasktracker.auth.data"
    }

    val xcfName = "coreAuthDataKit"
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
}
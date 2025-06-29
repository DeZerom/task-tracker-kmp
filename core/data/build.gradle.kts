plugins {
    alias(libs.plugins.build.core.data)
}

kotlin {
    androidLibrary {
        namespace = "ru.dezerom.tasktracker.core.data"
    }

    val xcfName = "coreDataKit"
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
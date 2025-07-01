plugins {
    alias(libs.plugins.build.kmpLibrary)
}

kotlin {
    androidLibrary {
        namespace = "ru.dezerom.tasktracker.auth.ui"
    }

    val xcfName = "coreAuthUiKit"
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
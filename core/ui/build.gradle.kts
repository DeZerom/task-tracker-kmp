plugins {
    alias(libs.plugins.build.core.ui)
}

kotlin {
    androidLibrary {
        namespace = "ru.dezerom.tasktracker.core.ui"
    }

    val xcfName = "coreUiKit"
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
            }
        }
    }
}
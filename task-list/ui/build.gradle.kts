plugins {
    alias(libs.plugins.build.feature.ui)
}

kotlin {
    androidLibrary {
        namespace = "ru.dezerom.tasktracker.taskList.ui"
    }

    val xcfName = "taskListUi"
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
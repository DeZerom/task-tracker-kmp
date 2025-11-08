plugins {
    alias(libs.plugins.build.feature.data)
}

kotlin {
    androidLibrary {
        namespace = "ru.dezerom.tasktracker.taskList.data"
    }

    val xcfName = "taskListDataKit"
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
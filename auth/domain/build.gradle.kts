plugins {
    alias(libs.plugins.build.feature.domain)
}

kotlin {
    androidLibrary {
        namespace = "ru.dezerom.tasktracker.auth.domain"
    }

    val xcfName = "authDomainKit"
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
                implementation(projects.auth.data)
            }
        }
    }
}
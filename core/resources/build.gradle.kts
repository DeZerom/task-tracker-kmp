plugins {
    alias(libs.plugins.build.kmpLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    androidLibrary {
        namespace = "ru.dezerom.tasktracker.core.resources"
        experimentalProperties["android.experimental.kmp.enableAndroidResources"] = true
    }

    val xcfName = "coreResourcesKit"
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
                implementation(compose.foundation)
                api(compose.components.resources)
            }
            resources.srcDirs("src/commonMain/composeResources")
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "ru.dezerom.tasktracker.core.resources"
}
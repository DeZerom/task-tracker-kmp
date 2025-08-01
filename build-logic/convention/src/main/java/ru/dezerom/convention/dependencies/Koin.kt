package ru.dezerom.convention.dependencies

import org.gradle.api.artifacts.VersionCatalog

val VersionCatalog.koinCore
    get() = findLibrary("koin-core").get()

val VersionCatalog.koinTest
    get() = findLibrary("koin-test").get()

val VersionCatalog.koinAndroid
    get() = findLibrary("koin-android").get()

val VersionCatalog.koinCompose
    get() = findLibrary("koin-compose").get()
rootProject.name = "otuskotlin-ads-vehicles"

pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        val bmuschkoDockerVersion: String by settings
        val springVersion: String by settings
        val springDependencyVersion: String by settings

        kotlin("jvm") version kotlinVersion apply false
        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false

        id("org.openapi.generator") version "4.3.1" apply false
        id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion apply false
        id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion apply false
        id("org.springframework.boot") version springVersion apply false
        id("io.spring.dependency-management") version springDependencyVersion apply false

        id("com.bmuschko.docker-java-application") version bmuschkoDockerVersion apply false
    }

    repositories {
        gradlePluginPortal()
        mavenCentral()
        jcenter()
    }
}

include(":ok-ads-vehicles-be-common")
include(":ok-ads-vehicles-be-storage-common")
include(":ok-ads-vehicles-be-storage-fixtures")
include(":ok-ads-vehicles-be-repo-inmemory")
include(":ok-ads-vehicles-mp-transport-models")
include(":ok-ads-vehicles-be-transport-mp")
include("ok-ads-vehicles-mp-common")
include(":ok-ads-vehicles-be-logics")
include(":ok-ads-vehicles-be-app-ktor")
//include("otuskotlin-ads-vehicles-openapi")

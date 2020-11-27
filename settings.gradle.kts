rootProject.name = "otuskotlin-ads-vehicles"

pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        val bmuschkoDockerVersion: String by settings

        kotlin("jvm") version kotlinVersion apply false
        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false

        id("com.bmuschko.docker-java-application") version bmuschkoDockerVersion apply false
    }

    repositories {
        gradlePluginPortal()
        mavenCentral()
        jcenter()
    }
}

include(":ok-ads-vehicles-be-common")
include(":ok-ads-vehicles-mp-transport-models")
include(":ok-ads-vehicles-be-transport-mp")
include(":ok-ads-vehicles-be-app-ktor")
//include("ok-ads-vehicles-mp-common")
include(":ok-ads-vehicles-be-repo-inmemory")

val ktorVersion: String by project
val logbackVersion: String by project

plugins {
    application
    kotlin("jvm")
    id("com.bmuschko.docker-java-application")
}

group = rootProject.group
version = rootProject.version

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

docker {
    javaApplication {
        baseImage.set("adoptopenjdk/openjdk11:alpine-jre")
        maintainer.set("Petr Berezhkov")
        ports.set(listOf(80))
        val imageName = project.name
        images.set(listOf(
                "$imageName:${project.version}",
                "$imageName:latest"
        ))
        jvmArgs.set(listOf("-Xms256m", "-Xmx512m"))
    }
}

repositories {
    mavenLocal()
    jcenter()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
}

dependencies {
    implementation(project(":ok-ads-vehicles-be-common"))
    implementation(project(":ok-ads-vehicles-be-logics"))
    implementation(project(":ok-ads-vehicles-mp-transport-models"))
    implementation(project(":ok-ads-vehicles-be-transport-mp"))
    implementation(project(":ok-ads-vehicles-be-storage-common"))
    implementation(project(":ok-ads-vehicles-be-storage-fixtures"))
    implementation(project(":ok-ads-vehicles-be-repo-inmemory"))

    implementation(kotlin("stdlib-jdk8"))
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-host-common:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
}

kotlin.sourceSets["main"].kotlin.srcDirs("src")
kotlin.sourceSets["test"].kotlin.srcDirs("test")

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("testresources")

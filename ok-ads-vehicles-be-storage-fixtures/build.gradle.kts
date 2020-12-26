plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation(project(":ok-ads-vehicles-be-common"))
    implementation(project(":ok-ads-vehicles-be-storage-common"))
}

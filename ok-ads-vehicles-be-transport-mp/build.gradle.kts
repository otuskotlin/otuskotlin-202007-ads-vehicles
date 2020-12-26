plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

dependencies {
    val coroutinesVersion: String by project

    implementation(project(":ok-ads-vehicles-be-common"))
    implementation(project(":ok-ads-vehicles-mp-transport-models"))

    implementation(kotlin("stdlib"))
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}

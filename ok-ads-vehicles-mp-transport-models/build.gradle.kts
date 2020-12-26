plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

group = rootProject.group
version = rootProject.version

kotlin {
    jvm()

    sourceSets {
        val serializationVersion: String by project

        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
//                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
    }
}
plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("kotlinx-serialization")
    id("app.cash.sqldelight") version "2.0.1"
    id("co.touchlab.skie") version "0.6.0"
}

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "MultiPlatformLibrary"
            export("dev.icerock.moko:mvvm-core:0.16.1")
            export("dev.icerock.moko:mvvm-flow:0.16.1")
        }
    }
    
    sourceSets {
        val ktorVersion = "2.3.4"

        val commonMain by getting {
            dependencies {
                dependencies {
                    /* other implementations */
                    implementation("co.touchlab:stately-common:2.0.0-rc3")
                    implementation("co.touchlab:stately-collections:2.0.0-rc3")
                    implementation("co.touchlab:stately-concurrency:2.0.0-rc3")
                    implementation("co.touchlab:stately-isolate:2.0.0-rc3")
                }

                configurations.all {
                    exclude(group = "co.touchlab", module = "stately-strict-jvm")
                }

                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                api("dev.icerock.moko:mvvm-core:0.16.1")
                api("dev.icerock.moko:mvvm-flow:0.16.1")
                implementation("io.insert-koin:koin-core:3.2.0")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")
                implementation("app.cash.sqldelight:coroutines-extensions:2.0.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation("io.insert-koin:koin-android:3.2.0")
                implementation("app.cash.sqldelight:android-driver:2.0.1")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
                implementation("app.cash.sqldelight:native-driver:2.0.1")
            }
        }
    }
}

android {
    namespace = "com.debanshu.animax"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("com.debanshu.animax")
        }
    }
}

plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.2.0-beta06").apply(false)
    id("com.android.library").version("8.2.0-beta06").apply(false)
    kotlin("android").version("1.9.10").apply(false)
    kotlin("multiplatform").version("1.9.10").apply(false)
    kotlin("plugin.serialization") version "1.7.20"
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

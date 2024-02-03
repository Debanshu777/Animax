plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.debanshu.animax.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.debanshu.animax.android"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.7"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.6.0-beta03")
    implementation("androidx.compose.ui:ui-tooling:1.6.0-beta03")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.0-beta03")
    implementation("androidx.compose.foundation:foundation:1.6.0-beta03")
    implementation("androidx.compose.material:material:1.6.0-beta03")
    implementation("androidx.activity:activity-compose:1.9.0-alpha01")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("io.coil-kt:coil-compose:2.5.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
    implementation("androidx.navigation:navigation-compose:2.7.6")

    val koin = "3.5.3"
    implementation("io.insert-koin:koin-android:${koin}")
    implementation("io.insert-koin:koin-androidx-compose:${koin}")
}
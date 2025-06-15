plugins {
    alias(libs.plugins.compose)
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    jvmToolchain(11)
}

android {
    compileSdk = 35
    namespace = "example.profile"
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        applicationId = "example.profile"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String", "API_URL", "\"http://10.0.2.2:9090\"")
    }
}


dependencies {
    api(libs.androidx.core)
    api(libs.androidx.appcompat)
    api(libs.androidx.activityCompose)

    implementation(compose.material3)
    implementation(compose.runtime)
    implementation(compose.foundation)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.contentNegotiation)
    implementation(libs.ktor.serialization.json)
    implementation(libs.kotlinx.serialization.json)
}

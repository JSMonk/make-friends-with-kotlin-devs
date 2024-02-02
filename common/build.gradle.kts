plugins {
    alias(libs.plugins.compose)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
}

version = "1.0-SNAPSHOT"

kotlin {
    jvm()
    androidTarget()
    jvmToolchain(11)
    js {
        browser()
        binaries.library()
        useEsModules()
        generateTypeScriptDefinitions()
        compilerOptions {
            target = "es2015"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.konform)
                implementation(compose.ui)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.components.resources)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.contentNegotiation)
                implementation(libs.ktor.serialization.json)
            }
        }
        val androidMain by getting {
            dependencies {
                api(libs.androidx.core)
                api(libs.androidx.appcompat)
                api(libs.androidx.activityCompose)
            }
        }
    }
}

android {
    compileSdk = 35
    namespace = "example.profile"
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    buildFeatures {
        buildConfig = true
    }
    defaultConfig {
        minSdk = 28
        buildConfigField("String", "API_URL", "\"http://10.0.2.2:9090\"")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
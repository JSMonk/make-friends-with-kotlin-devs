plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
}

version = "1.0-SNAPSHOT"

kotlin {
    jvm()
    androidTarget()
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
                implementation(libs.kotlinx.serialization.json)
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

    defaultConfig {
        minSdk = 28
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
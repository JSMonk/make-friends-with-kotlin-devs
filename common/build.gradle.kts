plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

version = "1.0-SNAPSHOT"
val ktorVersion = extra["ktor.version"]
val serializationVersion = extra["kotlinx.serialization.version"]

kotlin {
    jvm()
    androidTarget()
    js {
        browser()
        binaries.executable()
        useEsModules()
        generateTypeScriptDefinitions()

        // Known issue, is already fixed in the next version
        val main by compilations
        main.packageJson {
            this.main = this.main?.replace(".js", ".mjs")
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.konform:konform:0.4.0")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
            }
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile>().configureEach {
    kotlinOptions {
        useEsClasses = true
    }
}

android {
    compileSdk = 34
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = 28
        targetSdk = 34
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildTypes.forEach {
        it.buildConfigField("String", "API_URL", "\"http://10.0.2.2:9090\"")
    }
}
plugins {
    kotlin("android")
    kotlin("plugin.serialization")
    id("com.android.application")
    id("org.jetbrains.compose")
}

kotlin {
    jvmToolchain(11)
}

android {
    compileSdk = 34
    defaultConfig {
        applicationId = "example.profile"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildTypes.forEach {
        it.buildConfigField("String", "API_URL", "\"http://10.0.2.2:9090\"")
    }
}


compose {
    val composeVersion = project.property("compose.version") as String
    kotlinCompilerPlugin.set(composeVersion)
}

val ktorVersion = extra["ktor.version"]
val serializationVersion = extra["kotlinx.serialization.version"]

dependencies {
    api("androidx.core:core-ktx:1.9.0")
    api("androidx.appcompat:appcompat:1.6.1")
    api("androidx.activity:activity-compose:1.6.1")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
    implementation(compose.material3)
    implementation(compose.runtime)
    implementation(compose.foundation)
    implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
}

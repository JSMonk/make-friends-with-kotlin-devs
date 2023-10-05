plugins {
    application
    kotlin("jvm")
    kotlin("plugin.serialization")
}

application {
    mainClass.set("example.profile.api.ServerKt")
}

val ktorVersion = extra["ktor.version"]
val serializationVersion = extra["kotlinx.serialization.version"]

dependencies {
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-server-cors:$ktorVersion")
    implementation("io.ktor:ktor-server-compression:$ktorVersion")
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-request-validation:$ktorVersion")
    implementation("io.ktor:ktor-server-status-pages:$ktorVersion")
    implementation("io.konform:konform:0.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
}
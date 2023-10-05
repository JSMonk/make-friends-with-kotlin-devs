plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

version = "1.0-SNAPSHOT"

kotlin {
    js {
        moduleName = "example.profile"
        browser {
            commonWebpackConfig {
                outputFileName = "example.profile.mjs"
            }
        }
        useCommonJs()
        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
            }
        }
    }
}

compose.experimental {
    web.application {}
}

val copyJsResources = tasks.create("copyJsResourcesWorkaround", Copy::class) {
    dependsOn(tasks.getByName("jsDevelopmentExecutableCompileSync"))
    from(project(":common").file("src/commonMain/resources"))
    into("build/processedResources/js/main")
}

afterEvaluate {
    tasks.getByName("jsProcessResources").finalizedBy(copyJsResources)
}
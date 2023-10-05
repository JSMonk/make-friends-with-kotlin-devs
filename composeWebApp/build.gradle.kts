plugins {
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.multiplatform)
}

version = "1.0-SNAPSHOT"

kotlin {
    js {
        binaries.executable()
        compilerOptions {
            target = "es2015"
        }
        browser {
            commonWebpackConfig {
                outputFileName = "example.profile.mjs"
            }
        }
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(projects.common)
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
            }
        }
    }
}

//val copyJsResources = tasks.create("copyJsResourcesWorkaround", Copy::class) {
//    dependsOn(tasks.getByName("jsDevelopmentExecutableCompileSync"))
//    from(project(":common").file("src/commonMain/resources"))
//    into("build/processedResources/js/main")
//}
//
//afterEvaluate {
//    tasks.getByName("jsProcessResources").finalizedBy(copyJsResources)
//}
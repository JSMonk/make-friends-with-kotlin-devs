package example.profile.services

import io.ktor.client.*
import example.profile.BuildConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json

val client = HttpClient {
    install(ContentNegotiation) {
        json()
    }
    defaultRequest {
        url(urlString = BuildConfig.API_URL)
    }
}
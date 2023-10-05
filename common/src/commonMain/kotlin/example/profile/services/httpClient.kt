package example.profile.services

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json

expect val API_URL: String

val client = HttpClient {
    install(ContentNegotiation) {
        json()
    }
    defaultRequest {
        url(urlString = API_URL)
    }
}
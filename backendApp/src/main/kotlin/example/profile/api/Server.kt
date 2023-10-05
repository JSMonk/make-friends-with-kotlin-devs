package example.profile.api

import example.profile.api.mock.MOCK_TALK
import example.profile.api.model.Talk
import example.profile.api.validation.util.ktor.provideValidator
import example.profile.api.validation.validateTalk
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.plugins.compression.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    var talk = MOCK_TALK

    embeddedServer(Netty, 9090) {
        install(ContentNegotiation) {
            json()
        }
        install(Compression) {
            gzip()
        }
        install(RequestValidation) {
            provideValidator(validateTalk)
        }
        install(StatusPages) {
            exception<RequestValidationException> { call, cause ->
                call.respond(HttpStatusCode.BadRequest, cause.reasons.joinToString())
            }
        }
        install(CORS) {
            allowMethod(HttpMethod.Get)
            allowMethod(HttpMethod.Put)
            allowHeader(HttpHeaders.ContentType)
            anyHost()
        }
        routing {
            get("/talk") {
                call.respond(talk)
            }
            put("/talk") {
                talk = call.receive<Talk>().apply {
                    validateTalk(this)
                }
                call.respond(HttpStatusCode.NoContent)
            }
        }
    }.start(wait = true)
}
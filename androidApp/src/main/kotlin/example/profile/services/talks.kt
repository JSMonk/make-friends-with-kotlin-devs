package example.profile.services

import example.profile.api.model.Talk
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

suspend fun fetchTalkInfo(): Talk {
    return client.get("/talk").body()
}

suspend fun updateTalkInfo(talk: Talk) {
    client.put("/talk") {
        contentType(ContentType.Application.Json)
        setBody(talk)
    }
}
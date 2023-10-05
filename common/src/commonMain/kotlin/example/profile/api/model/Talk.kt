package example.profile.api.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.js.JsExport

@JsExport
@Serializable
data class Talk(
    val title: String,
    val description: String,
    val speaker: Speaker
) {
    fun toJson(): String = Json.encodeToString(this)

    companion object {
        fun fromJson(json: String) = Json.decodeFromString<Talk>(json)
    }
}

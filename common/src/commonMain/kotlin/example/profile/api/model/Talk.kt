package example.profile.api.model

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
data class Talk(
    val title: String,
    val description: String,
    val speaker: Speaker
)
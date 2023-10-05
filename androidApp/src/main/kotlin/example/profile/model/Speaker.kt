package example.profile.api.model

import kotlinx.serialization.Serializable

@Serializable
data class Speaker(
    val name: String,
    val image: String,
    val position: String,
    val about: String
)
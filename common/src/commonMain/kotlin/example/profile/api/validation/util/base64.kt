package example.profile.api.validation.util

import io.konform.validation.ValidationBuilder

private val BASE64_STRING_PATTERN = "^data:image/png;base64,(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$".toRegex()

fun ValidationBuilder<String>.base64() = addConstraint(
    "should be a base64 string",
    BASE64_STRING_PATTERN.toString()
) { it.matches(BASE64_STRING_PATTERN) }

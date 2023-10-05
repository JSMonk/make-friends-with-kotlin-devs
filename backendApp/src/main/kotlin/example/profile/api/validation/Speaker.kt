package example.profile.api.validation

import example.profile.api.model.Speaker
import example.profile.api.validation.util.base64
import io.konform.validation.Validation
import io.konform.validation.jsonschema.maxLength
import io.konform.validation.jsonschema.minLength

val validateSpeaker = Validation {
    Speaker::name required {
        minLength(3)
        maxLength(20)
    }
    Speaker::image required {
        base64()
    }
    Speaker::position required {
        minLength(10)
        maxLength(100)
    }
    Speaker::about required {
        minLength(10)
        maxLength(500)
    }
}
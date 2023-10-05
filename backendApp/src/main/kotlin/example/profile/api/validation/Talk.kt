package example.profile.api.validation

import example.profile.api.model.Talk
import io.konform.validation.Validation
import io.konform.validation.jsonschema.maxLength
import io.konform.validation.jsonschema.minLength

val validateTalk = Validation {
    Talk::title required {
        minLength(3)
        maxLength(100)
    }
    Talk::speaker required {
        run(validateSpeaker)
    }
    Talk::description required {
        minLength(20)
        maxLength(500)
    }
}

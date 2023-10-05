package example.profile.api.validation.util.ktor

import io.konform.validation.Validation
import io.ktor.server.plugins.requestvalidation.*

inline fun <reified T : Any> RequestValidationConfig.provideValidator(validator: Validation<T>) {
    validate<T> {
        val result = validator(it)
        if (result.errors.isEmpty()) {
            ValidationResult.Valid
        } else {
            val error = result.errors.first()
            ValidationResult.Invalid("${T::class.simpleName}${error.dataPath}: ${error.message}")
        }
    }
}
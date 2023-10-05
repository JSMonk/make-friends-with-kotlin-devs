package example.profile.api.validation

import io.konform.validation.Valid
import io.konform.validation.Validation
import io.konform.validation.ValidationResult

@JsExport
class JsValidationResult<T>(private val validationResult: ValidationResult<T>) {
    val isValid: Boolean get() = validationResult is Valid

    fun validationErrorFor(vararg path: String): String? {
        return validationResult.get(*path)?.joinToString(", ")
    }
}

@JsExport
fun <T> runValidations(validation: Validation<T>, instance: T): JsValidationResult<T> {
    return JsValidationResult(validation.validate(instance))
}
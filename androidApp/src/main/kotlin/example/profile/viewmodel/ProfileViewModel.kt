package example.profile.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import example.profile.api.model.Talk
import example.profile.api.validation.validateTalk
import example.profile.services.fetchTalkInfo
import io.konform.validation.Valid
import io.konform.validation.ValidationResult
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    var talk: Talk? by mutableStateOf<Talk?>(null)
        private set

    var validationErrors: ValidationResult<Talk>? by mutableStateOf(null)
        private set

    var serverErrorMessage by mutableStateOf("")
        private set

    fun validationErrorFor(vararg path: Any): String? {
        return validationErrors?.get(*path)?.joinToString(", ")
    }

    fun getTalkInfo() {
        viewModelScope.launch {
            try {
                talk = fetchTalkInfo()
            } catch (e: Exception) {
                serverErrorMessage = e.message.toString()
            }
        }
    }

    fun patchTalkInfo(talk: Talk?) {
        if (talk != null) {
            validationErrors = validateTalk(talk).takeIf { it !is Valid }
        }
        this.talk = talk
    }

    fun updateTalkInfo() {
        viewModelScope.launch {
            try {
                example.profile.services.updateTalkInfo(talk!!)
            } catch (e: Exception) {
                serverErrorMessage = e.message.toString()
            }
        }
    }
}
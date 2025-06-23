package example.profile.components.talk

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import org.jetbrains.skiko.wasm.onWasmReady

private var props by mutableStateOf(SpeakerImageProps())

@JsExport
class SpeakerImageProps @JsExport.Ignore constructor() {
    lateinit var base64: String
}

@OptIn(ExperimentalComposeUiApi::class)
@JsExport
fun renderSpeakerImage(id: String, onValueChange: (String) -> Unit = {}) {
    onWasmReady {
        ComposeViewport(id) {
            SpeakerImage(props.base64, onValueChange = onValueChange)
        }
    }
}

@JsExport
fun updateProps(update: SpeakerImageProps.() -> Unit) {
    props = SpeakerImageProps().apply(update)
}
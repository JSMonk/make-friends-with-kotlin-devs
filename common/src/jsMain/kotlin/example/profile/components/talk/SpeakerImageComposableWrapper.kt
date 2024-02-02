package example.profile.components.talk

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import org.jetbrains.skiko.wasm.onWasmReady
import kotlin.coroutines.suspendCoroutine

@JsExport
class SpeakerImageProps(val base64: String) {
    companion object {
        var props by mutableStateOf(SpeakerImageProps(""))
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@JsExport
fun renderSpeakerImage(id: String, onValueChange: (String) -> Unit = {}) {
    onWasmReady {
        CanvasBasedWindow(
            canvasElementId = id,
            requestResize = suspend { suspendCoroutine {  } },
            applyDefaultStyles = true
        ) {
            SpeakerImage(SpeakerImageProps.props.base64, onValueChange = onValueChange)
        }
    }
}
package example.profile

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import example.profile.components.components.Profile
import example.profile.viewmodel.ProfileViewModel
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        val vm = ProfileViewModel()
        CanvasBasedWindow("ProfileExample") {
            Profile(vm)
        }
    }
}
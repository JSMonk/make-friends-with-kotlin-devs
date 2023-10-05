package example.profile.components.talk

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap

actual internal fun ByteArray.toImageBitmap(): ImageBitmap {
    return error("Should not be used")
}

@Composable
actual internal fun createPhotoPickerLauncher(onValueChange: (String) -> Unit): () -> Unit {
    return error("Should not be used")
}

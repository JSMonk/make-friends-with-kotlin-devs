package example.profile.components.talk

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap

actual internal fun ByteArray.toImageBitmap(): ImageBitmap =
    error("Should not be called")

@Composable
actual internal fun createPhotoPickerLauncher(onValueChange: (String) -> Unit): () -> Unit =
    error("Should not be called")
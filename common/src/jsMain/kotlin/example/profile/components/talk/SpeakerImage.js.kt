package example.profile.components.talk

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import kotlinx.browser.document
import org.jetbrains.skia.Image
import org.w3c.dom.HTMLInputElement
import org.w3c.files.FileReader
import org.w3c.files.get

actual internal fun ByteArray.toImageBitmap(): ImageBitmap {
    return Image.makeFromEncoded(this).toComposeImageBitmap()
}

@Composable
actual internal fun createPhotoPickerLauncher(onValueChange: (String) -> Unit): () -> Unit {
    val inputElement = document.createElement("input")
        .unsafeCast<HTMLInputElement>()
        .apply {
            type = "file"
            onchange = handler@ {
                val target = it.target?.unsafeCast<HTMLInputElement>() ?: return@handler null
                val firstFile = target.files?.get(0) ?: return@handler null
                FileReader().apply {
                    onload = { onValueChange(it.target.unsafeCast<FileReader>().result)}
                    readAsDataURL(firstFile)
                }
            }
        }
    return {
        inputElement.click()
    }
}

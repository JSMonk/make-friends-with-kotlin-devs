@file:OptIn(ExperimentalEncodingApi::class)
package example.profile.components.talk

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

const val BASE64_PREFIX = "data:image/png;base64,"

expect internal fun ByteArray.toImageBitmap(): ImageBitmap
@Composable
expect internal fun createPhotoPickerLauncher(onValueChange: (String) -> Unit): () -> Unit

@Composable
fun SpeakerImage(base64: String, onValueChange: (String) -> Unit = {}) {
    val imageSize = 185.dp
    val imagePadding = 16.dp
    val transparentBlack = Color.Black.copy(alpha = 0.5f)
    val data = Base64.decode(base64.substringAfter(BASE64_PREFIX))
    val photoPickerLauncher = createPhotoPickerLauncher(onValueChange)
    Box(modifier = Modifier.padding(PaddingValues(bottom = 15.dp))) {
        Image(
            painter = BitmapPainter(data.toImageBitmap()),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .padding(imagePadding)
                .width(imageSize)
                .height(imageSize),
        )
        Button(
            onClick = { photoPickerLauncher.invoke() },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(transparentBlack, transparentBlack),
            modifier = Modifier
                .width(imageSize + imagePadding * 2)
                .height(imageSize + imagePadding * 2)

        ) {
            Text("EDIT", fontSize = 20.sp, color = Color.White)
        }
    }

}
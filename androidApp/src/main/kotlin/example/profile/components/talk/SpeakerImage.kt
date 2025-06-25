@file:OptIn(ExperimentalEncodingApi::class)
package example.profile.components.talk

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.ByteArrayOutputStream
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

const val BASE64_PREFIX = "data:image/.+?;base64,"

private fun ByteArray.toImageBitmap(): ImageBitmap {
    return BitmapFactory.decodeByteArray(this, 0, size).asImageBitmap()
}

@Composable
private fun createPhotoPickerLauncher(onValueChange: (String) -> Unit): () -> Unit {
    val context = LocalContext.current
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            val source = ImageDecoder.createSource(context.contentResolver, it!!)
            val stream = ByteArrayOutputStream()
            val bitmap = ImageDecoder.decodeBitmap(source)
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
            onValueChange("$BASE64_PREFIX${Base64.encode(stream.toByteArray())}")
        }
    )
    return {
        photoPickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }
}

@Composable
fun SpeakerImage(base64: String, onValueChange: (String) -> Unit = {}) {
    val imageSize = 185.dp
    val imagePadding = 16.dp
    val transparentBlack = Color.Black.copy(alpha = 0.5f)
    val data = Base64.decode(base64.replace(BASE64_PREFIX.toRegex(), ""))
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
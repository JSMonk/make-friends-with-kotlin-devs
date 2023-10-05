package example.profile.components.talk

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import example.profile.components.PrettyTextField
import example.profile.constants.LightGrey

@Composable
fun SpeakerDescription(
    value: String,
    error: String? = null,
    onValueChange: (String) -> Unit = {}
) {
    PrettyTextField(
        value = value,
        error = error,
        singleLine = false,
        onValueChange = onValueChange,
        color = Color.LightGrey,
        modifier = Modifier.padding(6.dp).fillMaxWidth(),
        textStyle = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
    )
}
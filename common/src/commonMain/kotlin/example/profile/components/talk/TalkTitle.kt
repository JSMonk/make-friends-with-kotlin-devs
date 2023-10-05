package example.profile.components.talk

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import example.profile.components.PrettyTextField

@Composable
fun TalkTitle(
    value: String,
    error: String? = null,
    onValueChange: (String) -> Unit = {}
) {
    PrettyTextField(
        value = value,
        error = error,
        onValueChange = onValueChange,
        color = Color.White,
        textStyle = MaterialTheme.typography.titleLarge.copy(
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.padding(6.dp).fillMaxWidth(),
    )
}
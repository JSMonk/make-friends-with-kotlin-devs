package example.profile.components.talk

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import example.profile.constants.DarkBlue

@Composable
fun SaveButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        shape = RectangleShape,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(Color.DarkBlue, Color.DarkBlue, Color.Gray),
        onClick = { onClick() },
        contentPadding = PaddingValues(
            start = 30.dp,
            top = 10.dp,
            end = 30.dp,
            bottom = 10.dp,
        )
    ) {
        Text(
            text = "Save".toUpperCase(),
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
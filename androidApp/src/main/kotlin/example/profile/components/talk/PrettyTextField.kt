package example.profile.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import example.profile.ui.extension.leftBorder

@Composable
fun PrettyTextField(
    value: String,
    modifier: Modifier = Modifier,
    error: String? = null,
    singleLine: Boolean = true,
    color: Color = Color.White,
    textStyle: TextStyle = TextStyle.Default,
    onValueChange: (String) -> Unit = {}
) {
    BasicTextField(
        value = value,
        singleLine = singleLine,
        onValueChange = onValueChange,
        cursorBrush = SolidColor(color),
        modifier = modifier.leftBorder(2.dp, if (error == null) Color.White else Color.Red),
        textStyle = textStyle.copy(color = color),
        decorationBox = @Composable { innerTextField ->
            Column(modifier = Modifier.padding(PaddingValues(start = 20.dp))) {
                innerTextField()
                error?.also { Text(it, color = Color.Red) }
            }
        }
    )
}
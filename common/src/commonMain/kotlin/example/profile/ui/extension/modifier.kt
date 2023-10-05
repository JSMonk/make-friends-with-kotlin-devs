package example.profile.ui.extension

import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

fun Modifier.leftBorder(strokeSize: Dp, color: Color) = composed {
    val density = LocalDensity.current
    val strokeSizePx = density.run { strokeSize.toPx() }

    Modifier.drawBehind {
        val height = size.height

        drawLine(
            color = color,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = 0f , y = height),
            strokeWidth = strokeSizePx
        )
    }
}
package cd.ketsiatshaba.whatsapp.common.views.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

@Composable
fun DashedImage(
    image: Painter,
    numberOfDashes: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null
        )

        Canvas(modifier = Modifier.matchParentSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            val dashLength = 10.dp.toPx()
            val gapLength = 5.dp.toPx()

            // Dessine les quatre côtés de la bordure
            drawLine(
                start = Offset(0f, 0f),
                end = Offset(canvasWidth, 0f),
                color = Color.Gray,
                strokeWidth = 2.dp.toPx(),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashLength, gapLength))
            )
            drawLine(
                start = Offset(0f, canvasHeight),
                end = Offset(canvasWidth, canvasHeight),
                color = Color.Gray,
                strokeWidth = 2.dp.toPx(),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashLength, gapLength))
            )
            drawLine(
                start = Offset(0f, 0f),
                end = Offset(0f, canvasHeight),
                color = Color.Gray,
                strokeWidth = 2.dp.toPx(),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashLength, gapLength))
            )
            drawLine(
                start = Offset(canvasWidth, 0f),
                end = Offset(canvasWidth, canvasHeight),
                color = Color.Gray,
                strokeWidth = 2.dp.toPx(),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashLength, gapLength))
            )
        }
    }
}
package cd.ketsiatshaba.whatsapp.common.views.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cd.ketsiatshaba.whatsapp.common.views.Colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsappTopBar() {
    TopAppBar(title = {
        Text(
            "WhatsApp",
            fontSize = 24.sp,
            color = Colors.LightGreen,
            fontWeight = FontWeight.Medium
        )

    },
        modifier = Modifier.drawBehind {
            val borderSize = 0.2.dp.toPx()
            drawLine(
                color = Color.Gray,
                start = Offset(0f, size.height),
                end = Offset(size.width, size.height),
                strokeWidth = borderSize
            )
        }, navigationIcon = {}, actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Outlined.PhotoCamera, contentDescription = "")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Outlined.Search, contentDescription = "")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Outlined.MoreVert, contentDescription = "")
            }
        })
}
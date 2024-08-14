package cd.ketsiatshaba.whatsapp.common.views.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cd.ketsiatshaba.whatsapp.R

@Composable
fun ImageCircle(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.image),
        contentDescription = "",
        modifier = modifier.size(50.dp)
    )
}
package cd.ketsiatshaba.whatsapp.chat.ui.views.chat.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import cd.ketsiatshaba.whatsapp.common.views.ui.components.ImageCircle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatTopBar(){
    TopAppBar(
        title = {
            Row {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "video cam icon")
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ImageCircle()
                    Column {
                        Text(
                            "Zgenius Coders",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            "Enligne",
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                }
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Videocam, contentDescription = "video cam icon")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Call, contentDescription = "video cam icon")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "video cam icon")
            }
        }
    )
}
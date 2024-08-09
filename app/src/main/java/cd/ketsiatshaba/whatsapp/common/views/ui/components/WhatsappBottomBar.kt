package cd.ketsiatshaba.whatsapp.common.views.ui.components

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Chat
import androidx.compose.material.icons.automirrored.rounded.Chat
import androidx.compose.material.icons.outlined.Autorenew
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.rounded.Autorenew
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Groups
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import cd.ketsiatshaba.whatsapp.common.views.Colors

@SuppressLint("AutoboxingStateCreation")
@Composable
fun WhatsappBottomBar() {
    val items = listOf(
        BottomItem(
            title = "Chats",
            selectedIcon = Icons.AutoMirrored.Rounded.Chat,
            unselectedIcon = Icons.AutoMirrored.Outlined.Chat
        ),
        BottomItem(
            title = "Actus",
            selectedIcon = Icons.Rounded.Autorenew,
            unselectedIcon = Icons.Outlined.Autorenew
        ),
        BottomItem(
            title = "Communautes",
            selectedIcon = Icons.Rounded.Groups,
            unselectedIcon = Icons.Outlined.Groups
        ),
        BottomItem(
            title = "Appels",
            selectedIcon = Icons.Rounded.Call,
            unselectedIcon = Icons.Outlined.Call
        )
    )
    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    BottomAppBar {
        items.forEachIndexed { index, bottomItem ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Colors.LightGreen
                ),
                label = { Text(text = bottomItem.title) },
                icon = {
                    Icon(
                        imageVector = if (selectedItem == index) {
                            bottomItem.selectedIcon
                        } else {
                            bottomItem.unselectedIcon
                        }, contentDescription = bottomItem.title
                    )
                })
        }
    }
}

data class BottomItem(
    var title: String,
    var selectedIcon: ImageVector,
    var unselectedIcon: ImageVector
)
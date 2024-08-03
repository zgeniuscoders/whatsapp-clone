package cd.ketsiatshaba.whatsapp.chat.ui.views.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Chat
import androidx.compose.material.icons.automirrored.rounded.Chat
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.Autorenew
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.Autorenew
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Groups
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cd.ketsiatshaba.whatsapp.R
import cd.ketsiatshaba.whatsapp.chat.domain.models.Chat
import cd.ketsiatshaba.whatsapp.common.views.Colors


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView() {

    val messages = listOf(
        Chat(0, "Fredo Sawala", "Salut", false, 1),
        Chat(1, "Zgenius Matondo", "Salut Cava ?", true, 1),
    )

    Scaffold(
        topBar = { WhatsappTopBar() },
        bottomBar = { WhatsappBottombar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = Colors.LightGreen
            ) {
                Icon(
                    Icons.Filled.AddComment,
                    contentDescription = "start chat",
                    tint = Color.White,
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(
                    vertical = innerPadding.calculateTopPadding(),
                    horizontal = 10.dp
                )
                .fillMaxSize()
        ) {
            item {
                ArchiveSection()
            }
            items(messages.size) {
                ChatItem(messages[it])
            }
        }
    }
}

@Composable
fun ArchiveSection() {
    Row(
        modifier = Modifier.padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(45.dp)
        ) {
            Icon(Icons.Outlined.Archive, contentDescription = "archive")
            Text(
                "Archivées",
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            "12",
            color = Colors.LightGreen
        )
    }
}


@Composable
fun ChatItem(chat: Chat) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "",
            modifier = Modifier.size(60.dp)
        )
        Column {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    chat.receiver,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    "09:40",
                    color = Color.Gray
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {

                Icon(
                    Icons.Filled.Check, contentDescription = "",
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )

                Text(
                    "Salut tu vas bien?",
                    fontSize = 16.sp,
                    color = Color.Gray
                )

                if (chat.isRead) {
                    Spacer(modifier = Modifier.weight(1f))
                    Card(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .align(Alignment.CenterVertically),
                        colors = CardDefaults.cardColors(
                            containerColor = Colors.LightGreen,
                        )
                    ) {
                        Text(
                            chat.unReadCount.toString(),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

            }
        }
    }
}

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

@SuppressLint("AutoboxingStateCreation")
@Composable
fun WhatsappBottombar() {
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

@Preview(name = "HomeView", showBackground = true)
@Composable
private fun PreviewHomeView() {
    HomeView()
}
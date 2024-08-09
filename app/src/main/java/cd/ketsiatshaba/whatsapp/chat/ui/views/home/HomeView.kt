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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cd.ketsiatshaba.whatsapp.R
import cd.ketsiatshaba.whatsapp.chat.domain.models.Chat
import cd.ketsiatshaba.whatsapp.common.views.Colors


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navHostController: NavHostController) {

    val messages = listOf(
        Chat(0, "Fredo Sawala", "Salut", false, 1),
        Chat(1, "Zgenius Matondo", "Salut Cava ?", true, 1),
    )

    LazyColumn(
            modifier = Modifier
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


@Preview(name = "HomeView", showBackground = true)
@Composable
private fun PreviewHomeView() {
    HomeView(navHostController = rememberNavController())
}
package cd.ketsiatshaba.whatsapp.chat.ui.views.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { WhatsappTopBar() }
    ) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsappTopBar() {

    TopAppBar(title = {
        Text(
            "Whatsapp",
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal
        )

    }, navigationIcon = {}, actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Notifications, contentDescription = "")
        }
    })

}



@Preview(name = "HomeView", showBackground = true)
@Composable
private fun PreviewHomeView() {
    HomeView()
}
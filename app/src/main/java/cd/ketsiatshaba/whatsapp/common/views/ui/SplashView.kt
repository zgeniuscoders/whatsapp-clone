package cd.ketsiatshaba.whatsapp.common.views.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cd.ketsiatshaba.whatsapp.common.Routes
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SplashView(navHostController: NavHostController) {

    LaunchedEffect(Unit) {
        delay(2000)
        navHostController.navigate(Routes.home_page.route)
    }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Card(
                modifier = Modifier.size(144.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF0CCC83)),
                shape = RoundedCornerShape(40.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        Icons.Filled.Whatsapp,
                        contentDescription = "whatsapp logo",
                        modifier = Modifier.size(94.dp),
                        tint = Color.White
                    )
                }
            }
        }

}


@Composable
@Preview(showBackground = true)
fun SplashPreview() {
    SplashView(navHostController = rememberNavController())
}
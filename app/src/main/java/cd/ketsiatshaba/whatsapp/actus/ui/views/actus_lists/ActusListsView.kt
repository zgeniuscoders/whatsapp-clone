package cd.ketsiatshaba.whatsapp.actus.ui.views.actus_lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cd.ketsiatshaba.whatsapp.R
import cd.ketsiatshaba.whatsapp.actus.ui.views.actus_lists.components.ActusItem

@Composable
fun ActusListsView(navHostController: NavHostController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                text = "Status",
                style = MaterialTheme.typography.titleMedium
            )
        }
        item {
            ActusItem()
        }
        item {
            Text(
                text = "Mises à jour rècentes",
                style = MaterialTheme.typography.titleMedium
            )
        }
        items(5) {
            ActusItem()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ActusListsPreview() {
    ActusListsView(rememberNavController())
}
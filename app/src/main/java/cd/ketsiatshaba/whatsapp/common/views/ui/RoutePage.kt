package cd.ketsiatshaba.whatsapp.common.views.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cd.ketsiatshaba.whatsapp.chat.ui.views.home.HomeView
import cd.ketsiatshaba.whatsapp.common.Routes
import cd.ketsiatshaba.whatsapp.common.views.Colors
import cd.ketsiatshaba.whatsapp.common.views.ui.components.WhatsappBottomBar
import cd.ketsiatshaba.whatsapp.common.views.ui.components.WhatsappTopBar

@Composable
fun RoutePage(navHostController: NavHostController) {

    val pageToShowBottomBar = listOf(
        Routes.home_page.route,
        Routes.actus_page.route,
        Routes.call_page.route,
        Routes.community_page.route
    )

    val pageToShowFloatingActionButton = listOf(
        Routes.home_page.route,
        Routes.call_page.route,
        Routes.actus_page.route
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute in pageToShowBottomBar) {
                WhatsappTopBar()
            }
        },
        bottomBar = {
            if (currentRoute in pageToShowBottomBar) {
                WhatsappBottomBar()
            }
        },
        floatingActionButton = {
            if (currentRoute in pageToShowFloatingActionButton) {
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
        }
    ) { innerP ->
        Column(
            modifier = Modifier.padding(innerP)
        ) {
            NavHost(
                navController = navHostController,
                startDestination = Routes.splash_page.route
            ) {
                composable(route = Routes.splash_page.route) {
                    SplashView(navHostController)
                }
                composable(route = Routes.home_page.route) {
                    HomeView(navHostController)
                }
            }
        }
    }
}

@Composable
@Preview
fun RoutePagePreview() {
    RoutePage(rememberNavController())
}
package com.pdmtaller2.AlexRamirez_00009423

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pdmtaller2.AlexRamirez_00009423.ui.theme.secondaryColor
import com.pdmtaller2.AlexRamirez_00009423.ui.theme.tertiaryColor


data class NavItem(
    val route: String,
    val label: String,
    val icon: ImageVector
)

@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        NavItem(Navigation.HomeScreen.route, "Restaurants", Icons.Filled.Home),
        NavItem(Navigation.SearchScreen.route, "Search", Icons.Filled.Search),
        NavItem(Navigation.OrdersScreen.route, "Orders", Icons.Filled.List)
    )

    NavigationBar(containerColor = secondaryColor, contentColor = Color.White) {
        val navBackStackEntry = navController.currentBackStackEntryAsState().value
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(text = item.label) }
            )
        }
    }
}
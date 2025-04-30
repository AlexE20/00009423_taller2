package com.pdmtaller2.AlexRamirez_00009423

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.pdmtaller2.AlexRamirez_00009423.screens.RestaurantMenuScreen

@Composable
fun RestaurantMenuRoute(
    navController: NavController,
    restaurantId: Int
) {
    val restaurantid = DummyData.DummyData.restaurants.find { it.id == restaurantId }

    if (restaurantid != null) {
        RestaurantMenuScreen(
            restaurant = restaurantid,
            onBack = { navController.popBackStack() }
        )
    } else {
        Text(text = "Restaurante no encontrado")
    }
}
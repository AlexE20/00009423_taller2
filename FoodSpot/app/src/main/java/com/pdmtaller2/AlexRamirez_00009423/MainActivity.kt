package com.pdmtaller2.AlexRamirez_00009423

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pdmtaller2.AlexRamirez_00009423.screens.FoodHomeScreen
import com.pdmtaller2.AlexRamirez_00009423.screens.RestaurantMenuScreen
import com.pdmtaller2.AlexRamirez_00009423.ui.theme.FoodSpotByAlexE20Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodSpotByAlexE20Theme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                    BottomBar(navController)
                }) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Navigation.HomeScreen.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Navigation.HomeScreen.route) {
                            FoodHomeScreen(
                                restaurants = DummyData.DummyData.restaurants,
                                onRestaurantClick = { restaurant ->
                                    navController.navigate("menu/${restaurant.id}")
                                }
                            )
                        }

                        composable(Navigation.SearchScreen.route) {
                            SearchScreen(restaurants = DummyData.DummyData.restaurants,
                                onRestaurantClick = { restaurant ->
                                    navController.navigate("menu/${restaurant.id}")
                                })
                        }
                        composable(Navigation.OrdersScreen.route) {
                            OrdersScreen()
                        }
                        composable("menu/{restaurantId}") { backStackEntry ->
                            val restaurantId =
                                backStackEntry.arguments?.getString("restaurantId")?.toIntOrNull()

                            if (restaurantId != null) {
                                RestaurantMenuRoute(
                                    navController = navController,
                                    restaurantId = restaurantId
                                )
                            } else {
                                Text("Invalid ID")
                            }
                        }
                    }
                }
            }
        }
    }
}


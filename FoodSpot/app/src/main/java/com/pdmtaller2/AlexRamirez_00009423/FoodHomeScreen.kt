package com.pdmtaller2.AlexRamirez_00009423.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pdmtaller2.AlexRamirez_00009423.FoodSpotData.Restaurant


fun groupRestaurantsByCategory(restaurants: List<Restaurant>): Map<String, List<Restaurant>> {
    return restaurants
        .flatMap { it.categories.map { category -> category to it } }
        .groupBy({ it.first }, { it.second })
}


@Composable
fun FoodHomeScreen(
    restaurants: List<Restaurant>,
    onRestaurantClick: (Restaurant) -> Unit
) {
    val groupedRestaurants = groupRestaurantsByCategory(restaurants)

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        groupedRestaurants.forEach { (category, restaurantList) ->
            item {
                Text(
                    text = category,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                )
            }
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(restaurantList) { restaurant ->
                        RestaurantCard(restaurant = restaurant, onClick = {
                            onRestaurantClick(restaurant)
                        })
                    }
                }
            }
        }
    }
}


@Composable
fun RestaurantCard(
    restaurant: Restaurant,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(end = 12.dp)
            .width(160.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = restaurant.imageRes),
            contentDescription = restaurant.name,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = restaurant.name,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

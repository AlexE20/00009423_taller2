package com.pdmtaller2.AlexRamirez_00009423.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pdmtaller2.AlexRamirez_00009423.FoodSpotData.Restaurant

fun groupRestaurants(restaurants: List<Restaurant>): Map<String, List<Restaurant>> {
    return restaurants
        .flatMap { it.categories.map { category -> category to it } }
        .groupBy({ it.first }, { it.second })
}


@Composable
fun FoodHomeScreen(
    restaurants: List<Restaurant>,
    onRestaurantClick: (Restaurant) -> Unit
) {
    val organizedRestaurants = groupRestaurants(restaurants)

    LazyColumn(
        modifier = Modifier.padding(10.dp)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        organizedRestaurants.forEach { (category, restaurantList) ->
            item {
                Text(
                    text = category,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 15.dp)
                )
            }
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
                ) {
                    items(restaurantList) { restaurantkIteration ->
                        RestaurantCard(
                            restaurant = restaurantkIteration,
                            onClick = { //I use "k" because it is drawing by iterations each card
                                onRestaurantClick(restaurantkIteration)
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
            .padding(end = 15.dp)
            .width(180.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = restaurant.imageRes),
            contentDescription = restaurant.name,
            modifier = Modifier
                .height(110.dp)
                .fillMaxWidth()
                .border(
                    width = 5.dp,
                    color = MaterialTheme.colorScheme.tertiary,
                    shape = RoundedCornerShape(40.dp)
                )
                .clip(RoundedCornerShape(40.dp)),
            contentScale = ContentScale.Crop

        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = restaurant.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.tertiary

        )
    }
}



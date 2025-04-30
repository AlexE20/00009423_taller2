package com.pdmtaller2.AlexRamirez_00009423


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.pdmtaller2.AlexRamirez_00009423.FoodSpotData.Restaurant
import com.pdmtaller2.AlexRamirez_00009423.screens.RestaurantCard
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment


@Composable
fun SearchScreen(
    restaurants: List<Restaurant>,
    onRestaurantClick: (Restaurant) -> Unit
) {
    var objectSearch by remember { mutableStateOf("") }

    val filteredList = remember(objectSearch) {
        if (objectSearch.isBlank()) emptyList()
        else searchAny(objectSearch, restaurants)
    }

    Column(
        modifier = Modifier.padding(1.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TextField(
            value = objectSearch,
            onValueChange = { objectSearch = it },
            placeholder = { Text("Search whatever you want") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
        )

        LazyColumn(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            items(filteredList) { restaurant ->
                RestaurantCard(restaurant = restaurant, onClick = {
                    onRestaurantClick(restaurant)
                })
            }
        }
    }
}

fun searchAny(query: String, restaurants: List<Restaurant>): List<Restaurant> {
    val standarizedQuery = query.lowercase()

    return restaurants.filter { restaurant ->
        val isNameMatched = restaurant.name.lowercase().contains(standarizedQuery)
        val isCategoryMatched =
            restaurant.categories.any { it.lowercase().contains(standarizedQuery) }
        val isDishMatched = restaurant.menu.any { it.name.lowercase().contains(standarizedQuery) }

        isNameMatched || isCategoryMatched || isDishMatched
    }
}



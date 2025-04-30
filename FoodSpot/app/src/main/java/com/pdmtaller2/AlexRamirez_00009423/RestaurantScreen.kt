package com.pdmtaller2.AlexRamirez_00009423.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pdmtaller2.AlexRamirez_00009423.FoodSpotData.Restaurant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantMenuScreen(
    restaurant: Restaurant,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    var dishSearched by rememberSaveable { mutableStateOf("") }

    val filteredMenu = restaurant.menu.filter { dish ->
        dish.name.contains(dishSearched, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("${restaurant.name} (${restaurant.description})") },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(30.dp)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value = dishSearched,
                onValueChange = { dishSearched = it },
                label = { Text("Search for dish") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(filteredMenu) { dish ->
                    Column(modifier = Modifier.padding(bottom = 16.dp)) {
                        Image(
                            painter = painterResource(id = dish.imageRes),
                            contentDescription = dish.name,
                            modifier = Modifier
                                .height(150.dp)
                                .fillMaxWidth()
                                .border(
                                    width = 3.dp,
                                    color = MaterialTheme.colorScheme.tertiary,
                                    shape = RoundedCornerShape(100.dp)

                                )
                                .clip(
                                    RoundedCornerShape(100.dp)
                                ),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = dish.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = dish.description,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )
                        Button(
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "${dish.name} added to cart",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = MaterialTheme.colorScheme.onPrimary,
                                disabledContentColor = Color.Blue
                            )

                        ) {
                            Text(text = "Add to cart")
                        }
                    }
                }
            }
        }
    }
}

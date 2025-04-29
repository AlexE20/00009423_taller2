package com.pdmtaller2.AlexRamirez_00009423

class FoodSpotData {
    data class Dish(
        val id: Int,
        val name: String,
        val description: String,
        val imageRes:Int,
    )

    data class Restaurant(
        val id: Int,
        val name: String,
        val description: String,
        val imageRes:Int,
        val categories: List<String>,
        val menu: List<Dish>
    )

}
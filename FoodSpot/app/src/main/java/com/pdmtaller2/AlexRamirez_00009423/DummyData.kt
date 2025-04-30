package com.pdmtaller2.AlexRamirez_00009423

import com.pdmtaller2.AlexRamirez_00009423.FoodSpotData.Dish
import com.pdmtaller2.AlexRamirez_00009423.FoodSpotData.Restaurant

class DummyData {
    object DummyData {

        val restaurants: List<Restaurant> = listOf(
            Restaurant(
                id = 1,
                name = "Lirel Cisa",
                description = "PICSA PICSA",
                imageRes =R.drawable.little,
                categories = listOf("Comida Rápida"),
                menu = listOf(
                    Dish(
                        id = 1,
                        name = "PEPERONI",
                        description = "LA MEJOR.",
                        imageRes = R.drawable.peperoni
                    ),
                    Dish(
                        id = 20,
                        name = "Jamon",
                        description = "LA MEJOR.",
                        imageRes = R.drawable.jamon
                    ),

                )
            ),
            Restaurant(
                id = 2,
                name = "Tacology",
                description = "Auténtica comida mexicana.",
                imageRes = R.drawable.tacology,
                categories = listOf("Comida Mexicana"),
                menu = listOf(
                    Dish(
                        id = 2,
                        name = "Tacos al Pastor",
                        description = "Tacos de cerdo al pastor con piña.",
                        imageRes = R.drawable.tacos
                    ),

                )
            ),
            Restaurant(
                id = 3,
                name = "Bombardiro Crocodilo",
                description = "Auténtica comida italiana.",
                imageRes = R.drawable.bombardiro,
                categories = listOf("Comida Italiana","Comida Rápida"),
                menu = listOf(
                    Dish(
                        id = 5,
                        name = "Tralalero Tralala",
                        description = "Pasta al estilo Napoletano.",
                        imageRes = R.drawable.tralalero
                    ),

                )
            ),
            Restaurant(
                id = 4,
                name = "Sushi World",
                description = "El mejor sushi y ramen de la ciudad.",
                imageRes = R.drawable.sushiito,
                categories = listOf("Comida Asiática"),
                menu = listOf(
                    Dish(
                        id = 7,
                        name = "Sushi Maki",
                        description = "Rollo de sushi clásico con aguacate.",
                        imageRes = R.drawable.suhsi
                    ),

                )
            ),
            Restaurant(
                id = 5,
                name = "Green Bites",
                description = "Comida saludable y deliciosa.",
                imageRes = R.drawable.gogreen,
                categories = listOf("Comida Saludable"),
                menu = listOf(
                    Dish(
                        id = 9,
                        name = "Ensalada Detox",
                        description = "Ensalada fresca con quinoa.",
                        imageRes = R.drawable.ensalada
                    ),

                )
            ),
            Restaurant(
                id = 6,
                name = "santa eduvigis   ",
                description = "Postres para cada antojo.",
                imageRes = R.drawable.santae,
                categories = listOf("Postres y Dulces"),
                menu = listOf(
                    Dish(
                        id = 11,
                        name = "semita",
                        description = "Pastel de queso con fresa.",
                        imageRes = R.drawable.semita
                    )
                )
            ),
            Restaurant(
                id = 7,
                name = "Boba Luba",
                description = "Jugos, batidos y bebidas naturales.",
                imageRes = R.drawable.bobaluba,
                categories = listOf("Bebidas","Comida Rápida"),
                menu = listOf(
                    Dish(
                        id = 13,
                        name = "boba",
                        description = "Refrescante y natural.",
                        imageRes = R.drawable.boba
                    ),

                )
            )
        )
    }
}

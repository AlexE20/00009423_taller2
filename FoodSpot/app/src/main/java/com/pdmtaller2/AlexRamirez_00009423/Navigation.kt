package com.pdmtaller2.AlexRamirez_00009423

import kotlinx.serialization.Serializable

@Serializable
sealed class Navigation(val route: String){
@Serializable
object HomeScreen: Navigation("home")
}
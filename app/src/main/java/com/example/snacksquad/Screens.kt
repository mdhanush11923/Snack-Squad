package main.example.snacksquadbiraj

sealed class Screens(val route: String) {
    object Home: Screens(route = "home")
    object Menu: Screens(route = "menu")
    object Food: Screens(route = "food")
}

package com.example.snacksquad

sealed class Screens(val route: String) {
    object Home: Screens("home")
    object Menu: Screens("menu")
    object Food: Screens("food")
    object Search : Screens("search")
    object Cart : Screens("cart")
    object Profile : Screens("profile")
    object Blank : Screens("blank")
}

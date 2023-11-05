package com.example.snacksquad

sealed class Screens(val route: String) {
    object Opening: Screens("opening")
    object Registration1: Screens("registration1")
    object Registration2: Screens("registration2")
    object Registration3: Screens("registration3")
    object Registration4: Screens("registration4")
    object Home: Screens("home")
    object Menu: Screens("menu")
    object Food: Screens("food")
    object Search : Screens("search")
    object Cart : Screens("cart")
    object Profile : Screens("profile")
    object Blank : Screens("blank")
}

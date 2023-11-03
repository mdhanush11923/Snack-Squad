package com.example.snacksquad

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(route = Screens.Home.route)
        {
            HomeScreen(navController = navController)
        }

        composable(route = "${Screens.Menu.route}/{categoryTitle}")
        {
            val categoryTitle = it.arguments?.getString("categoryTitle")
            MenuScreen(categoryTitle = categoryTitle, navController = navController)
        }

        composable(route = Screens.Food.route)
        {
            FoodScreen(navController = navController)
        }
    }
}
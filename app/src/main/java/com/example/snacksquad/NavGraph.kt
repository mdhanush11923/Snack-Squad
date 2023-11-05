package com.example.snacksquad

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screens.Profile.route
    ) {
        composable(route = Screens.Opening.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screens.Registration1.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screens.Registration2.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screens.Registration3.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screens.Registration4.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screens.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = "${Screens.Menu.route}/{categoryTitle}") {
            val categoryTitle = it.arguments?.getString("categoryTitle")
            MenuScreen(categoryTitle = categoryTitle, navController = navController, sharedViewModel = sharedViewModel)
        }

        composable(route = Screens.Food.route) {
            FoodScreen(navController = navController, sharedViewModel = sharedViewModel)
        }

        composable(route = Screens.Search.route) {
            Text("Tab 2 Content", modifier = Modifier.fillMaxSize())
        }

        composable(route = Screens.Cart.route) {
            Text("Tab 3 Content", modifier = Modifier.fillMaxSize())
        }

        composable(route = Screens.Profile.route) {
            ProfileScreen()
        }

        composable(route = Screens.Blank.route) {
            OpeningPage()
        }
    }
}
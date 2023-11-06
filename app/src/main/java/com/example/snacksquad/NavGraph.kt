package com.example.snacksquad

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.coroutines.delay
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SetStatusBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
    )
}
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Opening.route
    ) {
        composable(route = Screens.Home.route) {
            SetStatusBarColor(color = Color(0xFFFFF48F))
            HomeScreen(navController = navController)
        }

        composable(route = Screens.Opening.route) {
            SetStatusBarColor(color = Color(0xFF53DEE8))
            OpeningScreen(navController = navController)
        }

        composable(route = Screens.Registration1.route) {
            SetStatusBarColor(color = Color(0xffFFC85F))
            RegistrationScreen1(navController = navController)
        }

        composable(route = Screens.Registration2.route) {
            RegistrationScreen2(navController = navController)
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
            MenuScreen(categoryTitle = categoryTitle, navController = navController)
        }

        composable(route = Screens.Food.route) {
            FoodScreen(navController = navController)
        }

        composable(route = Screens.Search.route) {
            Text("Tab 2 Content", modifier = Modifier.fillMaxSize())
        }

        composable(route = Screens.Cart.route) {
            Text("Tab 3 Content", modifier = Modifier.fillMaxSize())
        }

        composable(route = Screens.Profile.route) {
            ProfileScreen(navController = navController)
        }

        composable(route = Screens.Blank.route) {
            Text("Tab 3 Content", modifier = Modifier.fillMaxSize())
        }
    }
}
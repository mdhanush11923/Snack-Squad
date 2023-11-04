package com.example.snacksquad

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

data class BottomNavItem(val route: String, val label: String, val imgResource: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationScreen(navController: NavHostController) {

    val bottomNavigationItems = listOf(
        BottomNavItem(Screens.Home.route, "Home", R.drawable.home),
        BottomNavItem(Screens.Search.route, "Search", R.drawable.search),
        BottomNavItem(Screens.Cart.route, "Cart", R.drawable.shopping_cart),
        BottomNavItem(Screens.Profile.route, "Profile", R.drawable.human)
    )

    val currentScreen by rememberUpdatedState(navController.currentBackStackEntryAsState().value?.destination?.route)

    Scaffold(
        bottomBar = {
            if (
                (currentScreen == Screens.Home.route)
                || (currentScreen == Screens.Search.route)
                || (currentScreen == Screens.Cart.route)
                || (currentScreen == Screens.Profile.route)
            ) {
                BottomNavigation(
                    modifier = Modifier
                        .padding(20.dp)
                        .clip(RoundedCornerShape(40.dp))
                        .height(70.dp),
                    backgroundColor = Color(0xff00484D),
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination?.route
                    bottomNavigationItems.forEach { item ->
                        BottomNavigationItem(
                            icon = {
                                Box(
                                    modifier = Modifier.size(60.dp),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    if (currentRoute == item.route) {
                                        Box(
                                            modifier = Modifier
                                                .size(55.dp)
                                                .clip(CircleShape)
                                                .background(Color(0xff72EEFF))
                                                .padding(5.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                painter = painterResource(item.imgResource),
                                                contentDescription = item.label
                                            )
                                        }
                                    } else {
                                        Box(
                                            modifier = Modifier
                                                .size(55.dp)
                                                .clip(CircleShape)
                                                .padding(5.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                painter = painterResource(item.imgResource),
                                                contentDescription = item.label
                                            )
                                        }
                                    }
                                }
                            },
                            selected = currentRoute == item.route,
                            onClick = {
                                navController.navigate(item.route) {
                                }
                            }
                        )
                    }
                }
            }

        }
    ) { innerPadding ->
        innerPadding
        SetupNavGraph(navController)
    }
}

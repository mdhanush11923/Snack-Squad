package com.example.snacksquad

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource

data class CategoryDetail(
    val title: String,
    val boxColor: Color,
    val subBoxColor: Color,
    val route: String = "menu"
)

data class FoodDetail(
    val name: String,
    val image: Int = R.drawable.circle,
    val desc: String = "",
    val price: Float = 200f,
    val cal: Int = 0,
    val rating: Float = 0f,
    val route: String = "tbd"
)

fun GetFoodItems(): MutableList<FoodDetail> {
    val food = mutableListOf<FoodDetail>()
    food.add(FoodDetail(
        name = "Burger",
        price = 150f,
        cal = 500,
        rating = 4.3f
    ))
    food.add(FoodDetail(
        name = "Pizza",
        price = 300f,
        cal = 700,
        rating = 4.5f
    ))
    food.add(FoodDetail(
        name = "Momo",
        price = 180f,
        cal = 300,
        rating = 4.9f
    ))
    food.add(FoodDetail(
        name = "Hot Dog",
        price = 220f,
        cal = 660,
        rating = 3.9f
    ))
    food.add(FoodDetail(
        name = "Gingerbread",
        price = 120f,
        cal = 140,
        rating = 4.0f
    ))

    return food
}
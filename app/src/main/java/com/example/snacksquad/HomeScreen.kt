package com.example.snacksquad

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController, sharedViewModel: SharedViewModel) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFFFFF48F))
            .padding(top = 30.dp)
            .fillMaxSize()
    ) {
        Card(
            backgroundColor = Color(0xFF40AFC2),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .width(310.dp)
                .height(70.dp)
        ) {
            Row{
                Text(
                    text = "Welcome, ",
                    fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                    fontSize = 25.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 18.dp, start = 27.dp)
                )
                Text(
                    text = "Dhanush",
                    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                    fontSize = 25.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 18.dp)
                )
            }

        }

        Spacer(modifier = Modifier.height(25.dp))

        LazyColumn(
            contentPadding = PaddingValues(
                start = 10.dp,
                end = 10.dp,
                top = 10.dp
            ),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            items(GetCategories()) { item: CategoryDetail ->
                CreateCategories(item, navController, sharedViewModel)
                //CreateCategories(title = item.title, boxColor = item.boxColor, subBoxColor = item.subBoxColor, route = item.route, navController)
            }

            item { Spacer(modifier = Modifier.height(80.dp)) }

        }
    }

}

@Composable
fun CreateCategories(item: CategoryDetail, navController: NavController, sharedViewModel: SharedViewModel) {
    Surface(
        color = item.boxColor,
        modifier = Modifier
            .requiredWidth(450.dp)
            .height(290.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp)
            ) {
                if (item.title != "Snack of the day") {
                    Card(
                        backgroundColor = item.subBoxColor,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .width(241.dp)
                            .height(50.dp)
                    ) {
                        Text(
                            text = item.title,
                            fontSize = 23.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                            color = Color.White,
                            modifier = Modifier.padding(top = 8.dp, start = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width((20.dp)))
                    Box(modifier = Modifier.padding(top = 5.dp)) {
                        Button(
                            shape = CircleShape,
                            modifier = Modifier.size(40.dp),
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFF42271E)),
                            onClick = { navController.navigate(route = "${Screens.Menu.route}/${item.title}") },
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.arrow),
                                contentDescription = ""
                            )
                        }
                    }

                }
                else {
                    Card(
                        backgroundColor = item.subBoxColor,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .width(300.dp)
                            .height(55.dp)
                    ) {
                        Text(
                            text = item.title,
                            fontSize = 23.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                            color = Color.White,
                            modifier = Modifier.padding(top = 10.dp, start = 50.dp)
                        )
                    }

                }
            }

            if (item.title != "Snack of the day") {
                LazyRow(
                    contentPadding = PaddingValues(start = 70.dp, end = 60.dp),
                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    items(GetFoodItems()) { item: FoodDetail ->
                        CreateFoodRow(item = item, navController = navController, sharedViewModel = sharedViewModel)
                    }
                }
            } else {
                val snackOfTheDay = remember { GetSnackOfTheDay() }
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp)
                    .background(Color.White)
                    .clickable {
                        sharedViewModel.addItem(newItem = snackOfTheDay)
                        navController.navigate(Screens.Food.route)
                    }
                ) {

                }

                Spacer(modifier = Modifier.padding(5.dp))

                Text(
                    text = snackOfTheDay.name,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.mottersemico))
                )

            }
        }
    }

    Spacer(modifier = Modifier.padding(15.dp))
}


@Composable
fun CreateFoodRow(item: FoodDetail, navController: NavController, sharedViewModel: SharedViewModel) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier
            .clip(CircleShape)
            .size(120.dp)
            .background(Color.White)
            .clickable {
                sharedViewModel.addItem(newItem = item)
                navController.navigate(Screens.Food.route)
            }
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "",
            )
        }

        Spacer(modifier = Modifier.padding(5.dp))

        Text(
            text = item.name,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.mottersemico))
        )
    }
}

fun GetCategories(): MutableList<CategoryDetail> {
    val menu = mutableListOf<CategoryDetail>()
    menu.add(CategoryDetail("Snack of the day", boxColor = Color(0xFFC1FF72), subBoxColor = Color(0xFF75D000)))
    menu.add(CategoryDetail("All snacks", boxColor = Color(0xFFFFC272), subBoxColor = Color(0xFFFF9000)))
    menu.add(CategoryDetail("Favorites", boxColor = Color(0xFFFF95D8), subBoxColor = Color(0xFFFF00A1)))
    menu.add(CategoryDetail("Popular", boxColor = Color(0xFF5CE1E6), subBoxColor = Color(0xFF40AFC2)))

    return menu
}

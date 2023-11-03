package com.example.snacksquad

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFFFFF48F))
            .fillMaxSize()
            .padding(vertical = 40.dp)
    ) {
        Card(
            backgroundColor = Color(0xFF40AFC2),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .width(350.dp)
                .height(64.dp)
        ) {
            Text(
                text = "Welcome, Dhanush",
                fontFamily = FontFamily(Font(R.font.montserratsemibold)),
                fontSize = 23.sp,//MaterialTheme.typography.h5.fontSize,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(13.dp)
            )
        }

        Spacer(modifier = Modifier.padding(14.dp))

        LazyColumn(
            contentPadding = PaddingValues(
                start = 10.dp,
                end = 10.dp,
                top = 10.dp
            ),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            items(GetCategories()) { item: CategoryDetail ->
                CreateCategories(item, navController)
                //CreateCategories(title = item.title, boxColor = item.boxColor, subBoxColor = item.subBoxColor, route = item.route, navController)
            }
        }
    }

}

@Composable
fun CreateCategories(item: CategoryDetail, navController: NavController) {
    Surface(
        color = item.boxColor,
        modifier = Modifier
            .requiredWidth(450.dp)
            .height(320.dp),
        shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp),
        elevation = 1.dp
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
                Card(
                    backgroundColor = item.subBoxColor,
                    shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp),
                    modifier = Modifier
                        .width(241.dp)
                        .height(45.dp)
                ) {
                    Text(
                        text = item.title,
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.montserratsemibold)),
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 5.dp, horizontal = 15.dp)
                    )
                }

                if (item.title != "Snack of the day") {
                    Spacer(modifier = Modifier.width((20.dp)))
                    Button(
                        shape = CircleShape,
                        modifier = Modifier.size(45.dp),
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF42271E)),
                        onClick = { navController.navigate(route = "${Screens.Menu.route}/${item.title}") },
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "rightArrow",
                            tint = Color.White
                        )
                    }
                }
            }

            if (item.title != "Snack of the day") {
                LazyRow(
                    contentPadding = PaddingValues(start = 60.dp, end = 60.dp),
                    horizontalArrangement = Arrangement.spacedBy(45.dp)
                ) {
                    items(GetFoodItems()) { item: FoodDetail ->
                        CreateFoodRow(item = item)
                        //Spacer(modifier = Modifier.width(15.dp))
                    }
                }
            } else {
                Image(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = "",
                    modifier = Modifier
                        .requiredSize(140.dp)
                )

                Spacer(modifier = Modifier.padding(5.dp))

                Text(
                    text = "Gingerbread",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.mottersemico))
                )
            }
        }
    }

    Spacer(modifier = Modifier.padding(15.dp))
}

fun GetCategories(): MutableList<CategoryDetail> {
    val menu = mutableListOf<CategoryDetail>()
    menu.add(CategoryDetail("Snack of the day", boxColor = Color(0xFFC1FF72), subBoxColor = Color(0xFF75D000)))
    menu.add(CategoryDetail("All snacks", boxColor = Color(0xFFFFC272), subBoxColor = Color(0xFFFF9000)))
    menu.add(CategoryDetail("Favorites", boxColor = Color(0xFFFF95D8), subBoxColor = Color(0xFFFF00A1)))
    menu.add(CategoryDetail("Popular", boxColor = Color(0xFF5CE1E6), subBoxColor = Color(0xFF40AFC2)))

    return menu
}

@Composable
fun CreateFoodRow(item: FoodDetail) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = "",
            modifier = Modifier
                .requiredSize(140.dp)
        )

        Spacer(modifier = Modifier.padding(5.dp))

        Text(
            text = item.name,
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.mottersemico))
        )
    }
}

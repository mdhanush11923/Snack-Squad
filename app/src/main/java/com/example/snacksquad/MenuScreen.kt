package com.example.snacksquad

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.snacksquad.R

@Composable
fun MenuScreen(categoryTitle: String? = null, navController: NavController) {
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
            shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp),
            modifier = Modifier
                .width(350.dp)
                .height(64.dp)
        ) {
            Text(
                text = categoryTitle!!,
                fontFamily = FontFamily(Font(R.font.montserratsemibold)),
                fontSize = 23.sp,
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
            val colors = mutableListOf<Color>()
            colors.add(Color(0xFFC1FF72))
            colors.add(Color(0xFFECABFF))
            colors.add(Color(0xFFFFC272))
            var ind = 0

            items(GetFoodItems()) { item: FoodDetail ->
                CreateFoodColumn(item, colors[ind], navController)

                ind++
                if (ind > 2)
                    ind = 0
            }
        }
    }
}

@Composable
fun CreateFoodColumn(item: FoodDetail, boxColor: Color, navController: NavController) {
    Surface(
        color = boxColor,
        modifier = Modifier
            .width(350.dp)
            .height(180.dp)
            .clickable {
                navController.navigate(route = Screens.Food.route)
            },
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 35.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start,
            ) {
                Text(
                    text = item.name,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.mottersemico))
                )

                Spacer(modifier = Modifier.width(20.dp))

                Surface(
                    shape = CircleShape,
                    color = Color(0xFFFFCE80),
                    modifier = Modifier
                        .height(28.dp)
                        .width(40.dp)
                        .offset(y = 1.dp)
                ) {
                    Text(
                        text = item.rating.toString(),
                        fontFamily = FontFamily(Font(R.font.montserratreg)),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.offset(y = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Calories ${item.cal}",
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.montserratreg))
            )
        }

        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(top = 30.dp, end = 25.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.circle),
                contentDescription = "",
                modifier = Modifier
                    .size(80.dp)
            )

            Spacer(modifier = Modifier.padding(5.dp))
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(start = 30.dp, bottom = 20.dp)
        ) {
            Text(
                text = "$${item.price}",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.montserratreg))
            )
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(end = 30.dp, bottom = 25.dp)
        )
        {
            Text(
                text = "Qty",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.montserratreg)),
            )

            Spacer(modifier = Modifier.width(5.dp))

            Button(
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier
                    .size(30.dp)
                    .offset(y = 5.dp),
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "-",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "10",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.montserratreg))
            )

            Spacer(modifier = Modifier.width(5.dp))

            Button(
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier
                    .size(30.dp)
                    .offset(y = 5.dp),
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "+",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    color = Color.White
                )
            }
        }

    }
    Spacer(modifier = Modifier.padding(15.dp))
}


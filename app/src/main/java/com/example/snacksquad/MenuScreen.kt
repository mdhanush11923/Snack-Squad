package com.example.snacksquad

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun MenuScreen(categoryTitle: String? = null, navController: NavController, sharedViewModel: SharedViewModel) {
    val colors = mutableListOf<Color>()
    colors.add(Color(0xFFC1FF72))
    colors.add(Color(0xFFECABFF))
    colors.add(Color(0xFFFFC272))
    var ind = 0
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFFFFF48F))
            .fillMaxSize()
            .padding(10.dp,40.dp,10.dp,0.dp)
    ) {
        Card(
            backgroundColor = Color(0xFFFF578E),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .width(320.dp)
                .height(70.dp)
        ) {
            Text(
                text = categoryTitle!!,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                fontSize = 27.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        Spacer(modifier = Modifier.padding(14.dp))

        LazyColumn(
            contentPadding = PaddingValues(
                start = 10.dp,
                end = 10.dp,
                top = 10.dp,
                bottom = 80.dp
            ),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {

            items(GetFoodItems(categoryTitle!!)) { item: FoodDetail ->
                CreateFoodColumn(item, colors[ind], navController, sharedViewModel)

                ind++
                if (ind > 2)
                    ind = 0
            }
        }
    }
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(30.dp),
            color = Color(0xFFFFCE80),
            modifier = Modifier
                .size(80.dp)
                .clickable {
                    navController.navigate(Screens.Cart.route)
                },
            border = BorderStroke(3.dp, Color.Black)
        ) {
            Image(
                painter = painterResource(id = R.drawable.cart),
                contentDescription = "",
                modifier = Modifier
                    .requiredSize(30.dp)
            )
        }
    }
}

@Composable
fun CreateFoodColumn(item: FoodDetail, boxColor: Color, navController: NavController, sharedViewModel: SharedViewModel) {
    Surface(
        color = boxColor,
        modifier = Modifier
            .width(350.dp)
            .height(180.dp)
            .clickable {
                sharedViewModel.addItem(newItem = item)
                navController.navigate(route = Screens.Food.route)
            },
        shape = RoundedCornerShape(30.dp),
        elevation = 0.dp
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 35.dp)
        ) {

            Text(
                text = item.name,
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.mottersemico)),
                modifier = Modifier
                    .padding(top = 2.dp)
                    .requiredWidth(160.dp)
            )

            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Calories ${item.cal}",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold))
            )
        }

        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(top = 30.dp, end = 25.dp)

        ) {
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color(0xFFFFCE80),
                modifier = Modifier
                    .height(26.dp)
                    .width(40.dp)
                    .offset(y = 5.dp)
            ) {
                Text(
                    text = item.rating.toString(),
                    fontFamily = FontFamily(Font(R.font.bebas_neue)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top= 3.dp),
                    fontSize = 17.sp
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            Box(modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
                .background(Color.White)
                .clickable {
                    sharedViewModel.addItem(newItem = item)
                    navController.navigate(Screens.Food.route)
                }
            ) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(80.dp)
                )
            }

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
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold))
            )
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(end = 30.dp, bottom = 25.dp)
        )
        {
            val qty = remember { mutableStateOf(Cart.cart.GetItemQty(item.name)) }

            Text(
                text = "Qty",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
            )

            Spacer(modifier = Modifier.width(5.dp))

            Box(
                modifier = Modifier
                    .size(30.dp)
                    .padding(top = 5.dp, start = 3.dp)
                    .clickable {
                        if (qty.value > 0) {
                            qty.value--
                            Cart.cart.RemoveFromCart(item)
                        }
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = ""
                )
            }

            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = qty.value.toString(),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold))
            )

            Spacer(modifier = Modifier.width(5.dp))

            Box(
                modifier = Modifier
                    .size(30.dp)
                    .padding(top = 5.dp)
                    .clickable {
                        qty.value++
                        Cart.cart.AddToCart(item)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = ""
                )
            }
        }
    }
    Spacer(modifier = Modifier.padding(15.dp))
}


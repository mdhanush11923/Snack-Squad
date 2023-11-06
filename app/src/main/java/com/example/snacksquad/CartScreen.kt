package com.example.snacksquad

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CartScreen() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
            .background(Color(0xFFFFF48F))
    ) {
        Surface(
            color = Color.White,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .width(350.dp)
                .height(60.dp),
        ) {
            Text(
                text = "Delivery to 1600 Amphitheater Way",
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(top = 20.dp, start = 15.dp)
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = "Order ( ${Cart.cart.qty} items )",
            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
            fontSize = 25.sp,
            modifier = Modifier
                .padding(top = 0.dp, start = 0.dp)
        )

        Spacer(modifier = Modifier.padding(5.dp))

        LazyColumn(
            contentPadding = PaddingValues(
                start = 10.dp,
                end = 10.dp,
                top = 10.dp,
                bottom = 110.dp
            ),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(Cart.cart.GetCartItems()) { item: FoodDetail ->
                if (item.qty > 0)
                    CreateCartColumn(item = item)
            }
            item {
                Surface(
                    color = Color(0xFFFF7070),
                    modifier = Modifier
                        .width(350.dp)
                        .height(80.dp),
                    shape = RoundedCornerShape(10.dp),
                    elevation = 0.dp
                ) {
                    val cal = remember { mutableStateOf(Cart.cart.cal) }
                    Text(
                        text = "Calorie Count: ${cal.value}",
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                        modifier = Modifier
                            .padding(top = 20.dp)
                    )
                }

                Spacer(modifier = Modifier.padding(10.dp))

                Surface(
                    color = Color(0xFF38B6FF),
                    modifier = Modifier
                        .width(350.dp)
                        .height(250.dp),
                    shape = RoundedCornerShape(10.dp),
                    elevation = 0.dp
                ) {
                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .padding(horizontal = 30.dp, vertical = 35.dp)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "Summary",
                            fontSize = 25.sp,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                            modifier = Modifier
                                .padding(top = 0.dp)
                        )

                        Text(
                            text = "Subtotal",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                            modifier = Modifier
                                .padding(top = 20.dp)
                        )

                        Text(
                            text = "Shipping & Handling",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                            modifier = Modifier
                                .padding(top = 20.dp)
                        )

                        Text(
                            text = "Total",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                            modifier = Modifier
                                .padding(top = 20.dp)
                        )
                    }

                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .padding(horizontal = 30.dp, vertical = 35.dp)
                            .fillMaxSize()
                    ) {
                        Icon(
                            Icons.Default.ArrowForward,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )

                        Text(
                            text = "$${String.format("%.2f", Cart.cart.total)}",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                            modifier = Modifier
                                .padding(top = 20.dp)
                        )

                        Text(
                            text = "$4.99",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                            modifier = Modifier
                                .padding(top = 20.dp)
                        )

                        Text(
                            text = "$${String.format("%.2f", Cart.cart.total + 4.99)}",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                            modifier = Modifier
                                .padding(top = 20.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun CreateCartColumn(item: FoodDetail) {
    Surface(
        color = Color(0xFFC1FF72),
        modifier = Modifier
            .width(350.dp)
            .height(180.dp),
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

        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 35.dp, top = 30.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(35.dp)
                    .padding(top = 5.dp)
                    .clip(CircleShape)
                    .clickable {
                        Cart.cart.DeleteFromCart(item)
                    }
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Clear, contentDescription = "")
            }
        }
    }
}
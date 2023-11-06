package com.example.snacksquad

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun FoodScreen(navController: NavController, sharedViewModel: SharedViewModel) {
    val item = sharedViewModel.item
    Box(
        modifier = Modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .background(Color(0xFFFFF48F))
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    shape = CircleShape,
                    modifier = Modifier.size(50.dp),
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    onClick = { navController.popBackStack() },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.padding(10.dp))

        Surface(
            color = Color(0xFF53DEE8),
            modifier = Modifier
                .requiredWidth(450.dp)
                .height(180.dp),
            elevation = 0.dp
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(start = 65.dp, bottom = 20.dp)
            ) {
                Text(
                    text = item?.name!!,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.mottersemico)),
                    modifier = Modifier
                        .requiredWidth(160.dp)
                )

                    Spacer(modifier = Modifier.padding(7.dp))

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

                    Spacer(modifier = Modifier.padding(7.dp))

                    Text(
                        text = "$${item.price}",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.montserratreg))
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .requiredWidth(450.dp)
                    .height(520.dp)
                    .background(Color(0xFF5CE1E6))
                    .padding(start = 65.dp, end = 65.dp, bottom = 55.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.padding(10.dp))

                Text(
                    text = "Details",
                    fontFamily = FontFamily(Font(R.font.montserratreg)),
                    fontSize = 15.sp,
                    color = Color(0xFF545454)
                )

            Spacer(modifier = Modifier.padding(5.dp))

                Text(
                    text = "Calories: ${item?.cal}",
                    fontFamily = FontFamily(Font(R.font.montserratreg)),
                    fontSize = 18.sp,
                )

                Spacer(modifier = Modifier.padding(5.dp))

                var seeMore by remember { mutableStateOf(true) }

                Text(
                    text = item?.desc!!,
                    fontFamily = FontFamily(Font(R.font.montserratreg)),
                    fontSize = 16.sp,
                    color = Color(0xFF545454),
                    maxLines = if (seeMore) 1 else Int.MAX_VALUE,
                    overflow = TextOverflow.Ellipsis

                )
                val textButton = if (seeMore) {
                    "See More"
                } else {
                    "See Less"
                }
                Text(
                    text = textButton,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                    modifier = Modifier
                        .heightIn(20.dp)
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                        .clickable {
                            seeMore = !seeMore
                        }
                )
                Spacer(modifier = Modifier.padding(5.dp))

                Text(
                    text = "Ingredients: ${item.ingr}",
                    fontFamily = FontFamily(Font(R.font.montserratreg)),
                    fontSize = 18.sp,
                )
            }
        }

    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(end = 20.dp, top = 20.dp)
    )
    {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(180.dp)
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = item?.image!!),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(180.dp)
            )
        }
    }

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(40.dp),
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),
                color = Color.White,
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .padding(start = 50.dp, end = 10.dp)
                ) {
                    val qty = remember { mutableStateOf(item?.qty!!) }

                    Text(
                        text = "Quantity",
                        fontFamily = FontFamily(Font(R.font.montserratreg)),
                        fontSize = 15.sp,
                    )

                    Box(
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                if (qty.value > 0) {
                                    qty.value--;
                                    item?.qty = qty.value
                                }
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.minus),
                            contentDescription = ""
                        )
                    }

                    Text(
                        text = qty.value.toString(),
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.montserratreg))
                    )

                    Box(
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                qty.value++
                                item?.qty = qty.value
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.add),
                            contentDescription = ""
                        )
                    }

                    Spacer(modifier = Modifier.width(5.dp))

                    Surface(
                        shape = RoundedCornerShape(30.dp),
                        color = Color(0xFFFFCE80),
                        modifier = Modifier
                            .height(50.dp)
                            .width(80.dp)
                            .clickable {

                            }
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
        }
    }
}

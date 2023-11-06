package com.example.snacksquad

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun OpeningScreen(navController: NavController) {
    val openingPageColor = Color(0xff53DEE8)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(openingPageColor)
            .padding(15.dp, 20.dp, 15.dp, 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(40.dp))
                .background(Color.White)
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 35.dp, start = 5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.snackk),
                        contentDescription = "Top Image",
                        modifier = Modifier
                            .height(200.dp)
                    )
                }

                Box(modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(40.dp, 5.dp, 40.dp, 50.dp)
                ){// Text Container
                    Text(
                        text = "A Customizable Snack Ordering And Delivery App",
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.montserrat_light)),
                        fontSize = 16.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) { // Bottom Container

                    Box(modifier = Modifier) { // Bottom Layer
                        Column(modifier = Modifier) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp)
                            ) { // Its Top
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(openingPageColor)
                            ) { // Its Bottom

                            }
                        }
                    }

                    Box(modifier = Modifier) { // Middle Layer
                        Column(modifier = Modifier) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(230.dp)
                            ) { // Its Top
                                Image(
                                    painter = painterResource(id = R.drawable.cookie),
                                    contentDescription = "Cookie Image",
                                    modifier = Modifier
                                        .fillMaxSize()
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) { // Its Bottom
                            }
                        }
                    }

                    Box(modifier = Modifier) { // Top Layer
                        Column(modifier = Modifier) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp)
                            ) { // Its Top
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(30.dp))
                                    .padding(horizontal = 10.dp)
                                    .background(color = openingPageColor.copy(alpha = 0.6f)),
                                contentAlignment = Alignment.BottomCenter
                            ) { // Its Bottom
                                Button(
                                    onClick= {
                                        navController.navigate(route = Screens.Registration1.route)
                                    },
                                    shape = RoundedCornerShape(25.dp),
                                    modifier = Modifier
                                        .align(alignment = Alignment.BottomCenter)
                                        .padding(bottom = 40.dp)
                                        .fillMaxWidth()
                                        .height(70.dp),
                                    colors = ButtonDefaults.outlinedButtonColors(
                                        containerColor = Color(0xffF5B97D),
                                        contentColor = Color.Black
                                    ),
                                    border = BorderStroke(width = 2.dp, color = Color.Black)

                                ) {
                                    Text(
                                        text = "Get Started",
                                        fontFamily = FontFamily(
                                            Font(R.font.montserrat_bold)
                                        ),
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(start = 50.dp)
                                    )
                                    
                                    Spacer(modifier = Modifier.width(40.dp))

                                    Box(
                                        modifier = Modifier
                                            .size(25.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.line_arrow),
                                            contentDescription = ""
                                        )
                                    }
                                }


                            }
                        }
                    }
                }
            }
        }
    }
}

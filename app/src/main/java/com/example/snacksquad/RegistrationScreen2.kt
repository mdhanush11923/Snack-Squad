package com.example.snacksquad

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen2(navController: NavController) {
    val registrationPageColor = Color(0xffFFC85F)
    var fieldShape = RoundedCornerShape(10.dp)
    var categoryNameStartPadding = 15.dp
    var categoryNameFontFamily = FontFamily(
        Font(R.font.montserrat_bold)
    )
    var categoryNameSize = 16.sp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(registrationPageColor)
            .padding(15.dp, 20.dp, 15.dp, 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(40.dp))
                .background(Color.White)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "2/4",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.montserrat_bold))
                    )
                }

                Text(
                    text = "Let's Craft Your Snackster Story",
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.mottersemico)),
                    fontSize = 22.sp,
                    color = Color(0xff6E4942),
                    modifier = Modifier.padding(horizontal = 30.dp)
                )

                Box(modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
                ){// Pie Container
                    Image(
                        painter = painterResource(id = R.drawable.piepiece2),
                        contentDescription = "Pie Image",
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.TopCenter)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))


                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(40.dp))
                        .background(registrationPageColor)
                ) {// Bottom Container

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(30.dp),
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 20.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Do you have any dietary preferences?",
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.mottersemico)),
                                fontSize = 22.sp,
                                color = Color(0xff6E4942),
                            )
                        }

                        Box(modifier = Modifier.padding(vertical = 10.dp)) {
                            Button(
                                onClick = {
                                    navController.navigate(route = Screens.Registration3.route)
                                },
                                shape = RoundedCornerShape(25.dp),
                                modifier = Modifier
                                    .align(alignment = Alignment.BottomCenter)
                                    .fillMaxWidth()
                                    .height(70.dp),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    containerColor = Color(0xffC1FF72),
                                    contentColor = Color.Black
                                ),
                                border = BorderStroke(width = 2.dp, color = Color.Black)

                            ) {
                                Text(
                                    text = "Yes, please",
                                    fontFamily = FontFamily(
                                        Font(R.font.montserrat_bold)
                                    ),
                                    fontSize = 18.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                        Box(modifier = Modifier.padding(top = 10.dp)) {
                            Button(
                                onClick = {
                                    navController.navigate(route = Screens.Registration3.route)
                                },
                                shape = RoundedCornerShape(25.dp),
                                modifier = Modifier
                                    .align(alignment = Alignment.BottomCenter)
                                    .fillMaxWidth()
                                    .height(70.dp),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    containerColor = Color(0xffFF7070),
                                    contentColor = Color.Black
                                ),
                                border = BorderStroke(width = 2.dp, color = Color.Black)

                            ) {
                                Text(
                                    text = "Nope",
                                    fontFamily = FontFamily(
                                        Font(R.font.montserrat_bold)
                                    ),
                                    fontSize = 18.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}




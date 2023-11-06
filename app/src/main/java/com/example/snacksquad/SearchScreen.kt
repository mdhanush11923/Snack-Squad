package com.example.snacksquad

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController, sharedViewModel: SharedViewModel) {
    var searchName by remember { mutableStateOf("") }
    var isErrorInSearch = false
    var fieldShape = RoundedCornerShape(10.dp)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF48F))
            .padding(30.dp)
    ) {
        Column {
            androidx.compose.material3.OutlinedTextField(
                value = searchName,

                onValueChange = {
                    searchName = it
                    isErrorInSearch = it.isEmpty()
                },

                shape = fieldShape,

                label = { androidx.compose.material3.Text(text = "Search Name", textAlign = TextAlign.Center, modifier = Modifier.padding(top = 5.dp)) },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),

                textStyle = TextStyle(
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_semibold)
                    )
                ),

                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFF5F5F5),
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Black,
                    focusedLabelColor = Color.Black
                ),

                supportingText = {
                    if (isErrorInSearch) {
                        androidx.compose.material3.Text(text = "Fill it")
                    }
                },

                isError = isErrorInSearch,
                
                leadingIcon = {
                    Box(modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)) {
                        Image(painter = painterResource(id = R.drawable.search), contentDescription = "")
                    }
                }
            )

            Spacer(modifier = Modifier.height(40.dp))

            androidx.compose.material3.Text(
                text = "Categories",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.mottersemico)),
                fontSize = 22.sp,
                color = Color(0xff6E4942),
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .width(140.dp)
                ) {
                    androidx.compose.material3.Button(
                        onClick = {
                            navController.navigate(route = Screens.Registration3.route)
                        },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .align(alignment = Alignment.BottomCenter)
                            .fillMaxWidth()
                            .height(60.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color(0xffFF7070),
                            contentColor = Color.Black
                        ),
                        border = BorderStroke(width = 2.dp, color = Color.Black)

                    ) {
                        androidx.compose.material3.Text(
                            text = "Nut",
                            fontFamily = FontFamily(
                                Font(R.font.montserrat_bold)
                            ),
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .width(140.dp)
                ) {
                    androidx.compose.material3.Button(
                        onClick = {
                            navController.navigate(route = Screens.Registration3.route)
                        },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .align(alignment = Alignment.BottomCenter)
                            .fillMaxWidth()
                            .height(60.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color(0xffFF7070),
                            contentColor = Color.Black
                        ),
                        border = BorderStroke(width = 2.dp, color = Color.Black)

                    ) {
                        androidx.compose.material3.Text(
                            text = "Desert",
                            fontFamily = FontFamily(
                                Font(R.font.montserrat_bold)
                            ),
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .width(140.dp)
                ) {
                    androidx.compose.material3.Button(
                        onClick = {
                            navController.navigate(route = Screens.Registration3.route)
                        },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .align(alignment = Alignment.BottomCenter)
                            .fillMaxWidth()
                            .height(60.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color(0xffFF7070),
                            contentColor = Color.Black
                        ),
                        border = BorderStroke(width = 2.dp, color = Color.Black)

                    ) {
                        androidx.compose.material3.Text(
                            text = "Hot",
                            fontFamily = FontFamily(
                                Font(R.font.montserrat_bold)
                            ),
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .width(140.dp)
                ) {
                    androidx.compose.material3.Button(
                        onClick = {
                            navController.navigate(route = Screens.Registration3.route)
                        },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .align(alignment = Alignment.BottomCenter)
                            .fillMaxWidth()
                            .height(60.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color(0xffFF7070),
                            contentColor = Color.Black
                        ),
                        border = BorderStroke(width = 2.dp, color = Color.Black)

                    ) {
                        androidx.compose.material3.Text(
                            text = "Sweet",
                            fontFamily = FontFamily(
                                Font(R.font.montserrat_bold)
                            ),
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .width(140.dp)
                ) {
                    androidx.compose.material3.Button(
                        onClick = {
                            navController.navigate(route = Screens.Registration3.route)
                        },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .align(alignment = Alignment.BottomCenter)
                            .fillMaxWidth()
                            .height(60.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color(0xffFF7070),
                            contentColor = Color.Black
                        ),
                        border = BorderStroke(width = 2.dp, color = Color.Black)

                    ) {
                        androidx.compose.material3.Text(
                            text = "Cold",
                            fontFamily = FontFamily(
                                Font(R.font.montserrat_bold)
                            ),
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .width(140.dp)
                ) {
                    androidx.compose.material3.Button(
                        onClick = {
                            navController.navigate(route = Screens.Registration3.route)
                        },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .align(alignment = Alignment.BottomCenter)
                            .fillMaxWidth()
                            .height(60.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color(0xffFF7070),
                            contentColor = Color.Black
                        ),
                        border = BorderStroke(width = 2.dp, color = Color.Black)

                    ) {
                        androidx.compose.material3.Text(
                            text = "Biscuit",
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

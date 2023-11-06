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
fun RegistrationScreen3(navController: NavController) {
    val registrationPageColor = Color(0xffFFC85F)
    var address1 by remember { mutableStateOf("") }
    var isErrorInAddress1 = false
    var address2 by remember { mutableStateOf("") }
    var isErrorInAddress2 = false
    var address3 by remember { mutableStateOf("") }
    var isErrorInAddress3 = false
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
                        text = "3/4",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.montserrat_bold))
                    )
                }

                Text(
                    text = "Share your Snackster HQ",
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
                        painter = painterResource(id = R.drawable.piepiece3),
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
                            .padding(20.dp, 30.dp, 20.dp, 0.dp),
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Enter your address",
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.mottersemico)),
                                fontSize = 22.sp,
                                color = Color(0xff6E4942),
                            )
                        }

                        Column {
                            OutlinedTextField(
                                value = address1,

                                onValueChange = {
                                    address1 = it
                                    isErrorInAddress1 = it.isEmpty()
                                },

                                label = { Text(text = "City/Town Name") },

                                shape = fieldShape,

                                modifier = Modifier
                                    .align(alignment = Alignment.CenterHorizontally)
                                    .fillMaxWidth(),

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
                                    if (isErrorInAddress1) {
                                        Text(text = "Fill it")
                                    }
                                },

                                isError = isErrorInAddress1
                            )

                            OutlinedTextField(
                                value = address2,

                                onValueChange = {
                                    address2 = it
                                    isErrorInAddress2 = it.isEmpty()
                                },

                                label = { Text(text = "Street/Local Area Name") },

                                shape = fieldShape,

                                modifier = Modifier
                                    .align(alignment = Alignment.CenterHorizontally)
                                    .fillMaxWidth(),

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
                                    if (isErrorInAddress2) {
                                        Text(text = "Fill it")
                                    }
                                },

                                isError = isErrorInAddress2
                            )

                            OutlinedTextField(
                                value = address3,

                                onValueChange = {
                                    address3 = it
                                    isErrorInAddress3 = it.isEmpty()
                                },

                                label = { Text(text = "Building floor Number") },

                                shape = fieldShape,

                                modifier = Modifier
                                    .align(alignment = Alignment.CenterHorizontally)
                                    .fillMaxWidth(),

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
                                    if (isErrorInAddress3) {
                                        Text(text = "Fill it")
                                    }
                                },

                                isError = isErrorInAddress3
                            )

                        }


                        Box(modifier = Modifier.padding(top = 10.dp)) {
                            Button(
                                onClick = {
                                    if (address1.isNotEmpty()) {
                                        if (address2.isNotEmpty()) {
                                            if (address3.isNotEmpty()) {

                                                navController.navigate(route = Screens.Registration4.route)

                                            }
                                            else {
                                                isErrorInAddress3 = true
                                            }
                                        }
                                        else {
                                            isErrorInAddress2 = true
                                        }
                                    }
                                    else {
                                        isErrorInAddress1 = true
                                    }
                                },
                                shape = RoundedCornerShape(25.dp),
                                modifier = Modifier
                                    .align(alignment = Alignment.BottomCenter)
                                    .fillMaxWidth()
                                    .height(70.dp),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    containerColor = Color(0xff5CE1E6),
                                    contentColor = Color.Black
                                ),
                                border = BorderStroke(width = 2.dp, color = Color.Black)

                            ) {
                                Text(
                                    text = "Confirm",
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




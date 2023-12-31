package com.example.snacksquad

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    var firstName by remember { mutableStateOf(User.user.firstName) }
    var isErrorInFistname = false
    var lastName by remember { mutableStateOf(User.user.lastName) }
    var isErrorInLastname = false
    var emailId by remember { mutableStateOf(User.user.emailId) }
    var isErrorInEmailId = false
    var password by remember { mutableStateOf(User.user.password) }
    var isErrorInPassword = false
    var address1 by remember { mutableStateOf(User.user.city) }
    var isErrorInAddress1 = false
    var address2 by remember { mutableStateOf(User.user.street) }
    var isErrorInAddress2 = false
    var address3 by remember { mutableStateOf(User.user.floor) }
    var isErrorInAddress3 = false
    var fieldShape = RoundedCornerShape(10.dp)

    Box(
        modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFFFF48F))
    ){
        LazyColumn {

            //Profile Placing Item
            item {
                Box(
                    modifier = Modifier
                    .height(280.dp)
                    .fillMaxWidth()
                    .padding(80.dp, 30.dp, 80.dp, 0.dp),
                    contentAlignment = Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Box(
                            modifier = Modifier
                            .clip(CircleShape)
                            .size(200.dp)
                            .background(Color(0xffC1FF72)),
                            contentAlignment = Center
                        ) {
                            Text(
                                text = User.user.firstName[0].toString().uppercase(),
                                fontSize = 100.sp,
                                fontFamily = FontFamily(
                                    Font(R.font.mottersemico)
                                ),
                            )
                        }
                        Box(
                            modifier = Modifier
                            .fillMaxSize(),
                            contentAlignment = Center
                        ){
                            Text(
                                text = "Profile",
                                fontSize = 30.sp,
                                fontFamily = FontFamily(
                                    Font(R.font.mottersemico)
                                ),
                                color = Color(0xff6E4942)
                            )
                        }
                    }
                }
            }


            //Fields Placing Item
            item {
                var categoryNameStartPadding = 15.dp
                var categoryNameFontFamily = FontFamily(
                    Font(R.font.montserrat_bold)
                )
                var categoryNameSize = 16.sp

                Box(
                    modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp, 20.dp, 30.dp, 0.dp),
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(
                            modifier = Modifier
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {

                            Column(modifier = Modifier
                                .fillMaxHeight()
                                .width(140.dp)
                            ) {

                                Column {
                                    Text(
                                        text = "Name",
                                        modifier = Modifier
                                            .padding(start = categoryNameStartPadding),
                                        fontFamily = categoryNameFontFamily,
                                        fontSize = categoryNameSize,
                                    )

                                    OutlinedTextField(
                                        value = firstName,

                                        onValueChange = {
                                            firstName = it
                                            isErrorInFistname = it.isEmpty()
                                        },

                                        shape = fieldShape,

                                        label = { Text(text = "Firstname") },

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
                                            if (isErrorInFistname) {
                                                Text(text = "Fill it")
                                            }
                                        },

                                        isError = isErrorInFistname
                                    )


                                }
                            }

                            Column(modifier = Modifier
                                .fillMaxHeight()
                                .width(140.dp)
                            ) {

                                Column {
                                    Text(
                                        text = "",
                                        modifier = Modifier
                                            .padding(start = categoryNameStartPadding),
                                        fontFamily = categoryNameFontFamily,
                                        fontSize = categoryNameSize
                                    )

                                    OutlinedTextField(
                                        value = lastName,

                                        onValueChange = {
                                            lastName = it
                                            isErrorInLastname = it.isEmpty()
                                        },

                                        shape = fieldShape,

                                        label = { Text(text = "Lastname") },

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
                                            if (isErrorInLastname) {
                                                Text(text = "Fill it")
                                            }
                                        },

                                        isError = isErrorInLastname
                                    )


                                }

                            }

                        }

                        Column {
                            Text(
                                text = "Email Id",
                                modifier = Modifier
                                    .padding(start = categoryNameStartPadding),
                                fontFamily = categoryNameFontFamily,
                                fontSize = categoryNameSize,
                            )

                            OutlinedTextField(
                                value = emailId,

                                onValueChange = {
                                    emailId = it
                                    isErrorInEmailId = it.isEmpty()
                                },

                                label = { Text(text = "Enter username") },

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
                                    if (isErrorInEmailId) {
                                        Text(text = "Fill it")
                                    }
                                },

                                isError = isErrorInEmailId
                            )


                        }

                        Column {
                            Text(
                                text = "Password",
                                modifier = Modifier
                                    .padding(start = categoryNameStartPadding),
                                fontFamily = categoryNameFontFamily,
                                fontSize = categoryNameSize,
                            )

                            OutlinedTextField(
                                value = password,

                                visualTransformation = PasswordVisualTransformation(),

                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                                onValueChange = {
                                    password = it
                                    isErrorInPassword = it.isEmpty()
                                },

                                label = { Text(text = "Enter username") },

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
                                    if (isErrorInPassword) {
                                        Text(text = "Fill it")
                                    }
                                },

                                isError = isErrorInPassword
                            )


                        }

                        Column {
                            Text(
                                text = "Address",
                                modifier = Modifier
                                    .padding(start = categoryNameStartPadding),
                                fontFamily = categoryNameFontFamily,
                                fontSize = categoryNameSize,
                            )

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
                    }

                }
            }

            //Button Placing Item
            item {
                Box(modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(30.dp,20.dp,30.dp,0.dp)
                ) {
                    Button(
                        onClick = {
                            if (firstName.isNotEmpty()) {
                                if (lastName.isNotEmpty()) {
                                    if (emailId.isNotEmpty()) {
                                        if (password.isNotEmpty()) {
                                            if (address1.isNotEmpty()) {
                                                if (address2.isNotEmpty()) {
                                                    if (address3.isNotEmpty()) {

                                                        navController.navigate(route = Screens.Home.route)

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
                                        }
                                        else {
                                            isErrorInPassword = true
                                        }
                                    }
                                    else {
                                        isErrorInEmailId = true
                                    }
                                }
                                else {
                                    isErrorInLastname = true
                                }
                            }
                            else {
                                isErrorInFistname = true
                            }
                        },
                        shape = RoundedCornerShape(25.dp),
                        modifier = Modifier
                            .align(alignment = TopCenter)
                            .padding(bottom = 20.dp)
                            .fillMaxWidth()
                            .height(65.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = Color(0xffC1FF72),
                                contentColor = Color.Black
                        ),
                        border = BorderStroke(width = 2.dp, color = Color.Black)

                    ) {
                        Text(
                            text = "Save Changes",
                            fontFamily = FontFamily(
                                Font(R.font.montserrat_bold)
                            ),
                            fontSize = 16.sp
                        )
                    }
                }
            }

        }
    }
}
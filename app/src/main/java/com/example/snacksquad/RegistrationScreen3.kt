package com.example.snacksquad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FourthPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffFFA500)) // Change the background color to orange
            .padding(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(40.dp))
                .background(Color.White) // Change the background color to white
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxSize()
                        .padding(20.dp, 30.dp, 20.dp, 0.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "3/4",
                            textAlign = TextAlign.Center,
                            fontSize = 22.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .offset(y = (-100).dp)
                        )

                        Text(
                            text = "Share your Snackster HQ",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color(0xFF8B4513 ),
                            modifier = Modifier
                                .offset(y = (-100).dp)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.search), // Replace with the second image resource
                        contentDescription = "Second Image",
                        modifier = Modifier
                            .size(175.dp)
                            .scale(1.5f)
                            .align(Alignment.TopCenter)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) { // Container

                    Box(modifier = Modifier) { // Bottom Layer
                        Column(modifier = Modifier) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(25.dp)
                            ) { /* Its Top */ }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(Color(0xffFFA500)) // Change the bottom layer background color to orange
                            ) { /* Its Bottom */ }
                        }
                    }

                    Box(modifier = Modifier) { // Middle Layer
                        Column(modifier = Modifier) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(250.dp)
                            ) { /* Its Top */ }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) { /* Its Bottom */ }
                        }
                    }

                    Box(modifier = Modifier) { // Top Layer
                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "Enter Your Address",
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                color = Color(0xFF8B4513),
                                modifier = Modifier
                                    .offset(y = 20.dp)


                            )

                            Spacer(modifier = Modifier.height(24.dp)) // Add spacing between image and text fields

                            TextField(
                                value = "City/Town",
                                onValueChange = { /* Handle value change */ },
                                label = { Text("City/Town") },
                                modifier = Modifier
                                    .fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(8.dp)) // Add spacing between text fields

                            TextField(
                                value = "Street/Local Area Name",
                                onValueChange = { /* Handle value change */ },
                                label = { Text("Street/Local Area Name") },
                                modifier = Modifier
                                    .fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(8.dp)) // Add spacing between text fields

                            TextField(
                                value = "Building Floor Name",
                                onValueChange = { /* Handle value change */ },
                                label = { Text("Building Floor Name") },
                                modifier = Modifier
                                    .fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(16.dp)) // Add spacing between text fields and button

                            Button(
                                onClick = { /* TODO() */ },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(Color(0xffADD8E6)) // Set the button background color to light blue
                            ) {
                                Text("Confirm", color = Color.Black)
                            }
                        }
                    }
                }
            }
        }
    }
}

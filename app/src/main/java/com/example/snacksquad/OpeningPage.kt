package com.example.snacksquad

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OpeningPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff53DEE8))
            .padding(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(40.dp))
                .background(Color.White)
        ) {
            Column {
                Box(modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(20.dp, 30.dp, 20.dp, 0.dp)) {
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
                ){
                    Text(
                        text = "A Customizable Snack Ordering And Delivery App",
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp
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
                                    .height(150.dp)
                            ) { // Its Top
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(Color(0xff53DEE8))
                            ) { // Its Bottom

                            }
                        }
                    }

                    Box(modifier = Modifier) { // Middle Layer
                        Column(modifier = Modifier) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(250.dp)
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
                                    .height(150.dp)
                            ) { // Its Top
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(color = Color(0xff53DEE8).copy(alpha = 0.6f))
                                    .padding(20.dp, 20.dp, 20.dp, 40.dp),
                                contentAlignment = Alignment.BottomCenter
                            ) { // Its Bottom
                                Button(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

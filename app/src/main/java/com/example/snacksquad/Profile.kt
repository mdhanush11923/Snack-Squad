package com.example.snacksquad

import android.provider.ContactsContract.Profile
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    var firstName by remember { mutableStateOf("") }
    var LastName by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Yellow)){
        LazyColumn {
            item {
                Box(modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
                    .padding(80.dp, 30.dp, 80.dp, 0.dp)
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {

                        Box(modifier = Modifier
                            .clip(CircleShape)
                            .size(200.dp)
                            .background(Color.Green)
                        ) {

                        }
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .background(Color.DarkGray),
                            contentAlignment = Center
                        ){
                            Text(text = "Profile", fontSize = 50.sp)
                        }
                    }


                }
            }
            item {
                Box(modifier = Modifier
                    .height(500.dp)
                    .fillMaxWidth()
                    .padding(30.dp, 20.dp, 30.dp, 0.dp)
                    .background(Color.Blue)
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {

                        Column(modifier = Modifier
                            .fillMaxHeight()
                            .width(135.dp)
                            .background(Color.Magenta)
                        ) {

                            Box {
                                Text(text = "Name", fontSize = 20.sp)
                                OutlinedTextField(value = firstName,
                                    onValueChange = {
                                        firstName = it
                                    })
                            }
                        }

                        Column(modifier = Modifier
                            .background(Color.Magenta)
                            .fillMaxHeight()
                            .width(135.dp)
                        ) {

                        }

                    }


                }
            }
            item {
                Box(modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.Red)
                ) {


                }
            }

        }
    }
}
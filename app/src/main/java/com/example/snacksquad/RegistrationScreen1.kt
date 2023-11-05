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
fun RegistrationScreen1(navController: NavController) {
    val registrationPageColor = Color(0xff53DEE8)

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
            Column {
                Box {
                    Text(
                        text = "1/4",
                        textAlign = TextAlign.Center,
                        fontSize = 22.sp,
                        color = Color.Black,
                    )
                }

                Text(
                    text = "The Start Is A Piece Of Cake!",
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                    fontSize = 24.sp,
                    color = Color(0xff6E4942)
                )

                Box(modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
                ){// Pie Container
                    Image(
                        painter = painterResource(id = R.drawable.piepiece1), // Replace with the second image resource
                        contentDescription = "Second Image",
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.TopCenter)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20.dp))
                        .background(registrationPageColor)
                ) {// Bottom Container
                    Column(modifier = Modifier) {


                    }
                }
            }
        }
    }
}




package br.senai.sp.jandira.screens.freelancer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.ui.theme.BalooTammudu
import br.senai.sp.jandira.ui.theme.Poppins

@Composable
fun FreelancerProfile(navController: NavController) {

    Surface (
        modifier = Modifier
            .fillMaxSize()
    ){

        Column (
            modifier = Modifier
                .fillMaxSize()
        ){

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 65.dp, start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                IconButton(onClick = {
   //                     navController.navigate("FreelancerHome")
                }) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBackIosNew,
                        contentDescription = "seta",
                        tint = Color(0xff011F4B)
                    )
                }
                IconButton(onClick = {
  //                      navController.navigate("SignUpMethod")
                }) {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = "caneta",
                        tint = Color(0xff011F4B)
                    )
                }
            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){

                Card (
                    modifier = Modifier
                        .size(210.dp),
                    shape = CircleShape
                ){
                    Image(
                        painter = painterResource(id = R.drawable.francisco),
                        contentDescription = "francisco",
                        contentScale = ContentScale.Fit)
                }

                Column (
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Text(
                        text = "Francisco de Almeida",
                        fontSize = 32.sp,
                        fontFamily = BalooTammudu,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.height(45.dp),
                        style = TextStyle(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xff011F4B),
                                    Color(0xff005B96)
                                )
                            )
                        )
                    )


                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp),
                        horizontalArrangement = Arrangement.Center
                    ){

                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = "star",
                            tint = Color(0xffFFC107))
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = "star",
                            tint = Color(0xffFFC107))
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = "star",
                            tint = Color(0xffFFC107))
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = "star",
                            tint = Color(0xffFFC107))
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = "star",
                            tint = Color(0xffFFC107))


                    }// Estrelas
                }

                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(
                            shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xff03396C),
                                    Color(0xff004470)
                                )
                            )
                        ),
                    colors = CardDefaults.cardColors(Color.Transparent)

                            ) {

                            Column (
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 20.dp, start = 40.dp, end = 40.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){

                                Text(
                                    text = "Sobre o Freelancer:",
                                    fontSize = 18.sp,
                                    fontFamily = Poppins,
                                    fontWeight = FontWeight.Medium,
                                    color = Color(0xffFFFFFF)
                                )

                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ut consequat enim, vitae venenatis urna. Mauris iaculis tellus orci, vitae elementum est auctor a. Vestibulum eget molestie ante. Ut consequat placerat justo et aliquet. ",
                                    fontSize = 13.sp,
                                    fontFamily = Poppins,
                                    fontWeight = FontWeight.Normal,
                                    color = Color(0xffEEEEEE)
                                )
                            }
                        }

            }




        }

    }

}


package br.senai.sp.jandira.screens.freelancer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
fun FreelanceHomeScreen() {

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 35.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        shape = RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp),
                        brush = Brush.linearGradient(
                            listOf(
                                Color(0xff03396C),
                                Color(0xff005B96)
                            )
                        )
                    )
                    .padding(top = 65.dp, start = 20.dp, bottom = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ){

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Card (
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .clickable {
                                //             navController.navigate("FreelancerProfile")
                            },
                        shape = CircleShape,
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.francisco),
                            contentDescription = "francisco"
                            )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "Francisco de Almeida",
                        fontFamily = Poppins,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xffFFFFFF)
                    )

                }

                Row {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "notify", tint = Color(0xffFFFFFF))
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Outlined.FilterList, contentDescription = "filter", tint = Color(0xffFFFFFF))
                    }
                }
            }


            LazyRow (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp,bottom = 45.dp, top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){

                items(10){
                    Card (
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(330.dp)
                            .padding(vertical = 10.dp)
                            .background(
                                Brush.linearGradient(
                                    0.0f to Color(0xff03396C),
                                    1.0f to Color(0xff005B96)
                                ),
                                shape = RoundedCornerShape(15.dp),
                            )
                            .clickable { }
                            ,
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        )
                    ){

                        Column (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 5.dp, end = 5.dp, top = 10.dp, bottom = 5.dp)
                        ){

                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "Elabore",
                                    fontFamily = BalooTammudu,
                                    color = Color(0xffFFFFFF),
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                                    fontFamily = Poppins,
                                    color = Color(0xffFFFFFF),
                                    fontSize = 13.sp
                                    )
                            }

                            LazyRow (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 15.dp)
                            ){

                                items(5){

                                    Card (
                                        modifier = Modifier
                                            .height(30.dp)
                                            .padding(horizontal = 5.dp),
                                        shape = RoundedCornerShape(10.dp),
                                        colors = CardDefaults.cardColors(containerColor = Color(0xffFFFFFF))
                                    ){
                                        Row (
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(5.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ){
                                            Image(painter = painterResource(id = R.drawable.js), contentDescription = "js", modifier = Modifier
                                                .size(20.dp)
                                                .clip(shape = RoundedCornerShape(5.dp)))
                                            Spacer(modifier = Modifier.width(5.dp))
                                            Text(text = "JavaScript", fontFamily = Poppins, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                                        }
                                    }
                                }

                            }

                            // Fim da lazyRow

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ){
                                Button(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .size(40.dp),
                                    shape = RoundedCornerShape(10.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xffFFFFFF))
                                ) {

                                    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                        Image(painter = painterResource(id = R.drawable.clickedchat), contentDescription = "chat")
                                    }

                                }
                            }
                        }

                    }

                    Spacer(modifier = Modifier.width(10.dp))
                }

            }


        }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 35.dp),
            verticalArrangement = Arrangement.Bottom
        ){

            Row (
                modifier = Modifier
                    .fillMaxWidth()
            ){

                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )

                ){

                    Row (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 45.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){


                            Image(
                                painter = painterResource(id = R.drawable.bag),
                                contentDescription = "projetos",
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(25.dp)
                                    .clickable {
                                        //               navController.navigate("ProjectsScreen")
                                    })



                            Image(
                                painter = painterResource(id = R.drawable.clickedhome),
                                contentDescription = "projetos",
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(25.dp)
                                    .clickable {
                                        //               navController.navigate("FreelanceHomeScreen")
                                    })




                            Image(
                                painter = painterResource(id = R.drawable.chat),
                                contentDescription = "projetos",
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(25.dp)
                                    .clickable {
                                        //                   navController.navigate("ChatList")
                                    })






                    }

                }


            }
        }
    }


}

@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun Prev() {
    FreelanceHomeScreen()
}
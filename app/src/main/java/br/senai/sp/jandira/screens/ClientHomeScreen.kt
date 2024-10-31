package br.senai.sp.jandira.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.R
import br.senai.sp.jandira.model.Freelancer
import br.senai.sp.jandira.model.Results
import br.senai.sp.jandira.service.RetrofitFactory
import br.senai.sp.jandira.ui.theme.BalooTammudu
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ClientHomeScreen() {

    var freelancerList by remember{
        mutableStateOf(listOf<Freelancer>())
    }

    var callFreelancerList = RetrofitFactory().createFreelancerService().getFreelancer()

    callFreelancerList.enqueue(object : Callback<Results> {
        override fun onResponse(p0: Call<Results>, p1: Response<Results>) {
            freelancerList = p1.body()!!.freelancers
        }

        override fun onFailure(p0: Call<Results>, p1: Throwable) {
        }

    })

    Surface (
        modifier = Modifier
            .fillMaxSize()
    ){

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 35.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 65.dp, start = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Card (
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp),
                        shape = CircleShape
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.francisco),
                            contentDescription = "francisco"
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "Francisco de Almeida",
                        fontFamily = BalooTammudu,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xff011F4B)
                    )

                }

                Row {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "notify")
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Outlined.FilterList, contentDescription = "notify")
                    }
                }
            }

            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 15.dp, end = 15.dp, bottom = 30.dp)
            ){

                items(freelancerList){
                    FreelancerCard(freelancer = it)
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
                    .padding(horizontal = 25.dp)
            ){

                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                        .background(
                            Brush.linearGradient(
                                0.0f to Color(0xff03396C),
                                1.0f to Color(0xff011F4B)
                            ),
                            shape = RoundedCornerShape(15.dp)
                        ),
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
                            painter = painterResource(id = R.drawable.mala),
                            contentDescription = "projetos",
                            modifier = Modifier
                                .height(25.dp)
                                .width(25.dp)
                                .clickable {
                                    //                                  navController.navigate("ProjectsScreen")
                                })
                        Image(
                            painter = painterResource(id = R.drawable.casa),
                            contentDescription = "projetos",
                            modifier = Modifier
                                .height(25.dp)
                                .width(25.dp)
                                .clickable {
                                    //                              navController.navigate("Home")
                                })
                        Image(
                            painter = painterResource(id = R.drawable.conversa),
                            contentDescription = "projetos",
                            modifier = Modifier
                                .height(25.dp)
                                .width(25.dp)
                                .clickable {
                                    //                               navController.navigate("ChatList")
                                })
                    }

                }


            }
        }

    }

}

@Composable
fun FreelancerCard(freelancer: Freelancer) {

    Card (
        modifier = Modifier
            .height(90.dp)
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .background(
                brush = Brush.linearGradient(
                    0.0f to Color(0xff011F4B),
                    1.0f to Color(0xff03396C)
                ),
                shape = RoundedCornerShape(10.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ){

        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){

            Card (
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp),
                shape = CircleShape
            ){

            }

            Text(
                text = freelancer.nome_freelancer,
                fontFamily = BalooTammudu,
                fontSize = 18.sp,
                color = Color(0xffFFFFFF)
            )

        }

    }
}

@Preview (showSystemUi = true, showBackground = true)
@Composable
private fun ClientHomePrev() {
    ClientHomeScreen()
}
package br.senai.sp.jandira.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.ui.theme.Poppins

@Composable
fun ChatListScreen(navController: NavController) {

    var search = remember {
        mutableStateOf("")
    }
    Surface (
        modifier = Modifier
            .fillMaxSize()
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, start = 10.dp)
            ) {
                IconButton(onClick = {
                  navController.navigate("FreelancerHome")
                }) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBackIosNew,
                        contentDescription = "seta",
                        tint = Color(0xff011F4B)
                    )
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 5.dp)
            ){

                OutlinedTextField(
                    value = search.value,
                    onValueChange = {
                        search.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "search",
                            tint = Color(0xff767676))
                    },
                    placeholder = {
                        Text(
                            text = "Search",
                            fontFamily = Poppins,
                            color = Color(0xff767676),
                            fontSize = 18.sp)
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xffECECEC),
                        unfocusedContainerColor = Color(0xffECECEC),
                        focusedBorderColor = Color(0xffECECEC),
                        unfocusedBorderColor = Color(0xffECECEC),
                        focusedTextColor = Color(0xff767676)
                    ),
                    shape = RoundedCornerShape(15.dp),
                    maxLines = 1)


            }
            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 35.dp)
            ){

                items(15){

                    Card (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .clickable { },
                        shape = RoundedCornerShape(0.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        )
                    ){
                        Row (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 20.dp)
                        ){

                            Column (
                                modifier = Modifier
                                    .fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ){
                                Card(
                                    modifier = Modifier
                                        .height(60.dp)
                                        .width(60.dp),
                                    shape = CircleShape
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.francisco),
                                        contentDescription = "foto_perfil",
                                        modifier = Modifier
                                            .height(60.dp)
                                            .width(60.dp))
                                }

                                Box (
                                    modifier = Modifier
                                        .height(60.dp)
                                        .width(60.dp)
                                ){

                                }
                            }

                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(start = 10.dp),
                                verticalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "Francisco de Almeida",
                                    fontSize = 18.sp,
                                    fontFamily = Poppins,
                                    color = Color(0xff222222)
                                )
                                Text(
                                    text = "lorem ipsum dolor amet ame romano latinus",
                                    fontSize = 8.sp,
                                    fontFamily = Poppins,
                                    color = Color(0xff767676),
                                    modifier = Modifier
                                        .padding(start = 5.dp)
                                )
                            }
                            Column (
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 20.dp),
                                horizontalAlignment = Alignment.End
                            ){
                                Card (
                                    modifier = Modifier
                                        .height(20.dp)
                                        .width(20.dp),
                                    shape = CircleShape,
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(0xff04DB00)
                                    )
                                ){}
                            }

                        }
                    }
                }

            }








        }

    }
}
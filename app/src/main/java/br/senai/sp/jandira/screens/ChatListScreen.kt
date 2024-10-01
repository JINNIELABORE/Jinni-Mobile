package br.senai.sp.jandira.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Brush
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.R
import br.senai.sp.jandira.ui.theme.Poppins

@Composable
fun ChatListScreen() {

    var search = remember {
        mutableStateOf("")
    }
    Surface (
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xffFFFFFF)
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 65.dp, start = 30.dp)
            ) {
                IconButton(onClick = {
//                    navController.navigate("SignUpMethod")
                }) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
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
                            contentDescription = "search")
                    },
                    placeholder = {
                        Text(text = "Search")
                    })


            }
            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
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
                                .padding(horizontal = 20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){

                            Image(
                                painter = painterResource(id = R.drawable.francisco),
                                contentDescription = "foto_perfil",
                                modifier = Modifier
                                    .background(color = Color.Transparent, shape = CircleShape))

                            Column(
                                modifier = Modifier
                                    .padding(start = 15.dp)
                            ){
                                Text(
                                    text = "Francisco de Almeida",
                                    fontSize = 20.sp,
                                    fontFamily = Poppins,
                                    color = Color(0xff222222)
                                )
                                Text(
                                    text = "lorem ipsum dolor amet ame romano latinus",
                                    fontSize = 10.sp,
                                    fontFamily = Poppins,
                                    color = Color(0xff767676),
                                    modifier = Modifier
                                        .padding(start = 5.dp)
                                )
                            }
                            Column {
                                Card {

                                }
                            }

                        }
                    }
                }

            }








        }

    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun ChatListPrev() {
    ChatListScreen()
}
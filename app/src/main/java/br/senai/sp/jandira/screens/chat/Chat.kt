package br.senai.sp.jandira.screens.chat

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.AttachFile
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.R
import br.senai.sp.jandira.model.message_dummy
import br.senai.sp.jandira.ui.theme.Poppins
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue


@Composable
fun MessageItem(
    messageText: String,
    isOut: Boolean
) {

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalAlignment = if (isOut){ Alignment.Start} else {Alignment.End},
    ){
        if(messageText != null || messageText != ""){

            if (isOut){


                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xffD9D9D9),
                                    Color(0xffCDCDCD)
                                )
                            ),
                            shape = RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 10.dp,
                                bottomStart = 10.dp,
                                bottomEnd = 10.dp
                            )
                        )
                        .padding(top = 8.dp, bottom = 8.dp, start = 10.dp, end = 10.dp)){
                    Text(text = messageText, color = Color(0xff222222))
                }

            }
            else{

                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xff03396C),
                                    Color(0xff005B96)
                                )
                            ),
                            shape = RoundedCornerShape(
                                topStart = 10.dp,
                                topEnd = 10.dp,
                                bottomStart = 10.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .padding(top = 8.dp, bottom = 8.dp, start = 10.dp, end = 10.dp)){
                    Text(text = messageText, color = Color(0xffFFFFFF))
                }

            }
        }

    }

}

@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun ChatPrev() {
    Chating()
}


@Composable
fun Chating() {



    val message = remember { mutableStateOf("") }

    Surface (
        modifier = Modifier
            .fillMaxSize()
    ){

        Column (
            modifier = Modifier
                .fillMaxSize()
        ){

            Column (
                modifier = Modifier.fillMaxWidth()
            ){

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, start = 10.dp)
                ) {
                    IconButton(onClick = {
//                    navController.navigate("SignUpMethod")
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
                        .padding(horizontal = 10.dp)
                ){

                    Card (
                        modifier = Modifier
                            .height(65.dp)
                            .fillMaxWidth()
                        ,
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        )
                    ){

                        Row (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 15.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ){

                            Card (
                                shape = CircleShape
                            ){
                                Image(
                                    painter = painterResource(R.drawable.francisco),
                                    contentDescription = "chico",
                                    modifier = Modifier
                                        .size(60.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(20.dp))

                            Text(
                                text = "Francisco de Almeida",
                                fontSize = 18.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Medium,
                                style = TextStyle(
                                    brush = Brush.linearGradient(
                                        listOf(
                                            Color(0xff011F4B),
                                            Color(0xff005B96)
                                        )
                                    )
                                )
                            )

                        }

                    }

                }

                LazyColumn (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(590.dp)
                        .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                ){

                    items(message_dummy){ chat ->
                        chat.text?.let { MessageItem(messageText = it, isOut = chat.isOut) }
                    }

                }



            }



            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 35.dp, start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ){

                OutlinedTextField(
                    value = message.value,
                    onValueChange = {
                        message.value = it
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xffEEEEEE),
                        focusedBorderColor = Color(0xffEEEEEE),
                        unfocusedContainerColor = Color(0xffEEEEEE),
                        focusedContainerColor = Color(0xffEEEEEE),
                        focusedTextColor = Color(0xff222222),
                        unfocusedTextColor = Color(0xff222222),
                        unfocusedPlaceholderColor = Color(0xff222222)
                    ),
                    modifier = Modifier
                        .height(55.dp)
                        .width(280.dp),
                    shape = RoundedCornerShape(10.dp),
                    placeholder = {
                        Text(
                            modifier = Modifier
                                .height(25.dp),
                            text = "Mensagem",
                            color = Color(0xff222222),
                            fontFamily = Poppins
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.AttachFile,
                            contentDescription = "anexo",
                            modifier = Modifier
                                .height(20.dp)
                                .clickable { },
                            tint = Color(0xff222222)
                        )
                    }

                )

                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(55.dp)
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xff03396C),
                                    Color(0xff005B96)
                                )
                            ),
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Send,
                        contentDescription = "enviar",
                        tint = Color(0xffFFFFFF)
                    )
                }


            }

            // Fim

        }


    }

    
}
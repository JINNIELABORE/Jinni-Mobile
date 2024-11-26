package br.senai.sp.jandira.screens.cadastros

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.components.GradientButton
import br.senai.sp.jandira.ui.theme.Poppins
import br.senai.sp.jandira.viewmodel.FreelancerViewModel
import java.time.LocalDate
import java.util.Calendar


@Composable
fun BirthdayScreen(freelancerViewModel: FreelancerViewModel, navController: NavController) {

    val maxDayMonth = 2
    val maxYear = 4

    val context = LocalContext.current

    var day = remember {
        mutableStateOf("")
    }
    var month = remember {
        mutableStateOf("")
    }
    var year = remember {
        mutableStateOf("")
    }
    var datanasc = remember {
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
                    .padding(top = 30.dp, start = 10.dp)
            ) {
                IconButton(onClick = {
                    navController.navigate("SignUpMethod")
                }) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBackIosNew,
                        contentDescription = "seta",
                        tint = Color(0xff011F4B)
                    )
                }
            }


            Column (
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 35.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(id = R.string.when_birthday),
                        fontSize = 20.sp,
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

                    Text(
                        text = stringResource(id = R.string.when_birthday),
                        fontSize = 12.sp,
                        fontFamily = Poppins,
                        color = Color(0xff6F6F6F)
                    )

                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 70.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.cake),
                            contentDescription = "cake",
                            modifier = Modifier
                                .size(100.dp))
                    }


                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){


                        Column (){

                            Text(text = stringResource(id = R.string.day))
                            OutlinedTextField(
                                value = day.value,
                                onValueChange = { if (it.length <= maxDayMonth) day.value = it},
                                modifier = Modifier
                                    .width(70.dp)
                                    .padding(horizontal = 5.dp),
                                shape = RoundedCornerShape(10.dp),
                                maxLines = 1,
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedContainerColor = Color(0xffE5E5E5),
                                    unfocusedContainerColor = Color(0xffE5E5E5),
                                    focusedBorderColor = Color(0xff000000),
                                    unfocusedBorderColor = Color.Transparent,
                                    focusedTextColor = Color(0xff222222)
                                ),
                            )
                        }

                        Column (){

                            Text(text = stringResource(id = R.string.month))
                            OutlinedTextField(
                                value = month.value,
                                onValueChange = { if (it.length <= maxDayMonth) month.value = it},
                                modifier = Modifier
                                    .width(70.dp)
                                    .padding(horizontal = 5.dp),
                                shape = RoundedCornerShape(10.dp),
                                maxLines = 1,
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedContainerColor = Color(0xffE5E5E5),
                                    unfocusedContainerColor = Color(0xffE5E5E5),
                                    focusedBorderColor = Color(0xff000000),
                                    unfocusedBorderColor = Color.Transparent,
                                    focusedTextColor = Color(0xff222222)
                                ),
                            )
                        }

                        Column (){

                            Text(text = stringResource(id = R.string.year))
                            OutlinedTextField(
                                value = year.value,
                                onValueChange = { if (it.length <= maxYear) year.value = it},
                                modifier = Modifier
                                    .padding(horizontal = 5.dp),
                                shape = RoundedCornerShape(10.dp),
                                maxLines = 1,
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedContainerColor = Color(0xffE5E5E5),
                                    unfocusedContainerColor = Color(0xffE5E5E5),
                                    focusedBorderColor = Color(0xff000000),
                                    unfocusedBorderColor = Color.Transparent,
                                    focusedTextColor = Color(0xff222222)
                                ),
                                )
                        }

                        datanasc.value = "$day-$month-$year"



                    }










                }
            }









        }

        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 60.dp, vertical = 35.dp),
            verticalAlignment = Alignment.Bottom
        ){

            if(day.value.isNotEmpty() && month.value.isNotEmpty() && year.value.isNotEmpty() && day.value.length == maxDayMonth && month.value.length == maxDayMonth && year.value.length == maxYear){
                Button(
                    onClick = {
                        if(datanasc.value.isNotEmpty()){
                            FreelancerViewModel().addBirthday(datanasc.value)
                            navController.navigate("FreelancerSignUp")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                        .background(
                            Brush.linearGradient(
                                0.0f to Color(0xff011F4B),
                                1.0f to Color(0xff03396C)
                            ),
                            shape = RoundedCornerShape(10.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.continue_),
                        color = Color(0xffFFFFFF),
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp)
                }
            } else{

                Button(
                    onClick = {
                        Toast.makeText(context, "Preencha o campo corretamente", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffE4E4E4)
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.continue_),
                        color = Color(0xff979797),
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp)
                }
            }





        }
    }

}



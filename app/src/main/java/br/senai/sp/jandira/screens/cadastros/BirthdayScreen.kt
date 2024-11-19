package br.senai.sp.jandira.screens.cadastros

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.components.GradientButton
import br.senai.sp.jandira.ui.theme.Poppins
import br.senai.sp.jandira.viewmodel.FreelancerViewModel


@Composable
fun BirthdayScreen() {

    var showDatePicker by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }


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
                    .padding(top = 65.dp, start = 10.dp)
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

            GradientButton(
                onClick = {

                    if(datanasc.value.isNotEmpty()){
                        FreelancerViewModel().addBirthday(datanasc.value)
//                        navController.navigate("FreelancerSignUp")
                    }
                },
                text = stringResource(id = R.string.continue_)
            )


        }
    }

}



@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun Prev() {
    BirthdayScreen()
}


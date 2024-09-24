package br.senai.sp.jandira.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.components.GradientButton
import br.senai.sp.jandira.ui.theme.BalooTammudu
import br.senai.sp.jandira.ui.theme.Poppins

@Composable
fun LoginScreen(navController: NavController) {

    var email = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color(0xffFFFFFF)
    ){

        Column (
            modifier = Modifier.fillMaxSize()
        ){

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 65.dp, start = 25.dp)
            ){
                IconButton(onClick = {
                    navController.navigate("FirstPage")
                }) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "seta",
                        tint = Color(0xff011F4B)
                    )
                }
            }

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = stringResource(id = R.string.sign_in),
                    color = Color(0xff011F4B),
                    fontSize = 24.sp,
                    fontFamily = BalooTammudu)
            }

            Column (
                modifier = Modifier.padding(horizontal = 35.dp, vertical = 30.dp)
            ){

                OutlinedTextField(
                    value = email.value,
                    onValueChange = {
                        email.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    shape = RoundedCornerShape(10.dp),
                    label = {
                        Text(
                            text = stringResource(id = R.string.email),
                            color = Color(0xff222222),
                            fontFamily = Poppins
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xffFBFBFB),
                        unfocusedContainerColor = Color(0xffFBFBFB),
                        focusedBorderColor = Color(0xff000000),
                        unfocusedBorderColor = Color(0xff6F6F6F),
                        focusedTextColor = Color(0xff222222)

                    )
                )

                OutlinedTextField(
                    value = password.value,
                    onValueChange = {
                        password.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    shape = RoundedCornerShape(10.dp),
                    label = {
                        Text(
                            text = stringResource(id = R.string.password),
                            color = Color(0xff222222),
                            fontFamily = Poppins
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xffFBFBFB),
                        unfocusedContainerColor = Color(0xffFBFBFB),
                        focusedBorderColor = Color(0xff000000),
                        unfocusedBorderColor = Color(0xff6F6F6F),
                        focusedTextColor = Color(0xff222222)

                    )
                )

                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    Text(
                        text = stringResource(id = R.string.signup_text),
                        fontFamily = Poppins,
                        fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = stringResource(id = R.string.sign_up),
                        fontFamily = Poppins,
                        color = Color(0xff011F4B),
                        fontSize = 12.sp,
                        modifier = Modifier.clickable { navController.navigate("SignUpMethod") }
                    )
                }
            }

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 60.dp, vertical = 35.dp),
                verticalArrangement = Arrangement.Bottom
            ){

                GradientButton(onClick = { }, text = stringResource(id = R.string.continue_))
            }


        }
    }

}


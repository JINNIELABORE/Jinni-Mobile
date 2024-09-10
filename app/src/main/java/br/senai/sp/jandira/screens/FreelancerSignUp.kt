package br.senai.sp.jandira.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.R
import br.senai.sp.jandira.ui.theme.BalooTammudu
import br.senai.sp.jandira.ui.theme.Poppins

@Composable
fun FreelancerSignUp() {
    
    var freelancerName = remember {
        mutableStateOf("")
    }

    var freelancerEmail = remember {
        mutableStateOf("")
    }

    var freelancerPassword = remember {
        mutableStateOf("")
    }

    var freelancerConfirmPassword = remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xffFFFFFF)

    ) {
        
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            
            Row (
                modifier = Modifier.fillMaxWidth().padding(top = 70.dp, start = 30.dp)
            ){
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "seta",
                    tint = Color(0xff011F4B)
                )
            }

            Column (
                modifier = Modifier.fillMaxWidth()
            ){

                Column (
                    modifier = Modifier.padding(horizontal = 35.dp)
                ){
                    Text(
                        text = stringResource(id = R.string.get_started),
                        fontSize = 24.sp,
                        fontFamily = BalooTammudu,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xff011F4B)
                    )

                    Text(
                        text = stringResource(id = R.string.get_started_text),
                        fontSize = 10.sp,
                        fontFamily = Poppins,
                        color = Color(0xff6F6F6F))
                }

                Column (
                    modifier = Modifier
                        .padding(horizontal = 35.dp)
                ){

                    OutlinedTextField(
                        value = freelancerName.value,
                        onValueChange = {
                            freelancerName.value = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(10.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.name),
                                color = Color(0xff222222),
                                fontFamily = Poppins)
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color(0xff000000)
                        )
                    )

                   
                }


            }
        }


    }
}


@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun FreelancerSignUpPrev() {
    FreelancerSignUp()
}
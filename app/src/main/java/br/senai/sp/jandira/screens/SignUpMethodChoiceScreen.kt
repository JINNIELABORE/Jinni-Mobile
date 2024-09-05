package br.senai.sp.jandira.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.ui.theme.BalooTammudu

@Composable
fun SignUpMethodChoiceScreen() {

    Surface (
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xffFFFFFF)
    ){

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){

            Text(
                text = stringResource(id = R.string.sign_up_as),
                fontSize = 24.sp,
                fontFamily = BalooTammudu,
                color = Color(0xff011F4B)
            )
        }

        Column (
            modifier = Modifier
        ){

            Card(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xffFEFEFE)
                ),
                border = BorderStroke(2.dp, Color(0xff03396C))
            ) {

                Column (
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(id = R.drawable.client),
                        contentDescription = "client"
                    )
                    Text(
                        text = stringResource(id = R.string.client),
                        fontSize = 18.sp,
                        fontFamily = BalooTammudu,
                        color = Color(0xff03396C)
                    )
                }
            }
        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun SigUpPreview() {
    SignUpMethodChoiceScreen()
}
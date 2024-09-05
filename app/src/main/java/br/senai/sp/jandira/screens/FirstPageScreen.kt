package br.senai.sp.jandira.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.ui.theme.BalooTammudu
import br.senai.sp.jandira.ui.theme.Tamma

@Composable
fun FirstPageScreen(navController: NavController) {


    Surface (
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xffFFFFFF)
    ){

        Column (modifier = Modifier
            .fillMaxSize()){


            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 120.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Image(
                    painter = painterResource(id = R.drawable.genius),
                    contentDescription = "sla")

                Text(
                    text = stringResource(id = R.string.app_name),
                    color = Color(0xff03396C),
                    fontSize = 64.sp,
                    fontFamily = BalooTammudu,
                    fontWeight = FontWeight.Normal
                )
            }

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 60.dp, vertical = 35.dp),
                verticalArrangement = Arrangement.Bottom
            ){
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffE4E4E4)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    onClick = {
                    }) {
                    Text(
                        text = stringResource(id = R.string.sign_in),
                        color = Color(0xff767676),
                        fontFamily = BalooTammudu,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff03396C)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    onClick = {
                        navController.navigate("SignUpMethod")
                    }) {
                    Text(
                        text = stringResource(id = R.string.sign_up),
                        color = Color(0xffFFFFFF),
                        fontFamily = BalooTammudu,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun FirstPageScreenPreview() {
}
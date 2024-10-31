package br.senai.sp.jandira.screens.cadastros


import androidx.compose.foundation.Image
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
import br.senai.sp.jandira.components.GradientButton
import br.senai.sp.jandira.ui.theme.BalooTammudu

@Composable
fun FirstPageScreen(navController: NavController) {


    Surface (
        modifier = Modifier
            .fillMaxSize()
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
                    fontWeight = FontWeight.SemiBold
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
                        navController.navigate("SignIn")
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

                GradientButton(onClick = {
                    navController.navigate("SignUpMethod")
                }, text = stringResource(id = R.string.sign_up))
            }
        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun FirstPageScreenPreview() {
}
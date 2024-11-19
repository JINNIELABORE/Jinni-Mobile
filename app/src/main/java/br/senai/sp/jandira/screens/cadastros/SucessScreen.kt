package br.senai.sp.jandira.screens.cadastros

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import br.senai.sp.jandira.R
import br.senai.sp.jandira.components.GradientButton
import br.senai.sp.jandira.ui.theme.Poppins

@Composable
fun Sucess() {

    Surface (
        modifier = Modifier
            .fillMaxSize()
    ){

        Column (
            modifier = Modifier
                .fillMaxSize()
        ){


            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 130.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Text(
                    text = "Conta criada com sucesso!",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
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
                    text = "Agora voce pode desfrutar dos serviços do Jinni",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp)

            }

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 120.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Image(
                    painter = painterResource(id = R.drawable.sucess),
                    contentDescription = "sucess")

            }

        }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 60.dp, vertical = 35.dp),
            verticalArrangement = Arrangement.Bottom
        ){

            GradientButton(onClick = {  }, text = stringResource(id = R.string.continue_))

        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun SucessScreen() {
    Sucess()
}
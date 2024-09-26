package br.senai.sp.jandira.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.R
import br.senai.sp.jandira.ui.theme.BalooTammudu

@Composable
fun FreelanceHomeScreen() {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xffFFFFFF)
    ) {

        Column (
            modifier = Modifier.fillMaxSize()
        ){

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 65.dp, start = 25.dp)
            ){

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.francisco),
                        contentDescription = "francisco",
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp))

                    Text(
                        text = "Francisco de Almeida",
                        fontFamily = BalooTammudu,
                        fontSize = 16.sp)

                }

                Row {

                }
            }

        }
    }

}

@Preview (showSystemUi = true, showBackground = true)
@Composable
private fun Homeprev() {
    FreelanceHomeScreen()
}
package br.senai.sp.jandira.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
            modifier = Modifier.fillMaxSize().padding(bottom = 35.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 65.dp, start = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Card (
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp),
                        shape = CircleShape
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.francisco),
                            contentDescription = "francisco"
                            )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "Francisco de Almeida",
                        fontFamily = BalooTammudu,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xff011F4B)
                    )

                }

                Row {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "notify")
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "notify")
                    }


                }
            }


            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp)
            ){

                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                        .background(
                            Brush.linearGradient(
                            0.0f to Color(0xff03396C),
                            1.0f to Color(0xff011F4B)
                        ),
                            shape = RoundedCornerShape(15.dp)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )

                ){

                    Row (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 45.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){

                        Image(
                            painter = painterResource(id = R.drawable.mala),
                            contentDescription = "projetos",
                            modifier = Modifier
                                .height(25.dp)
                                .width(25.dp))
                        Image(
                            painter = painterResource(id = R.drawable.casa),
                            contentDescription = "projetos",
                            modifier = Modifier
                                .height(25.dp)
                                .width(25.dp))
                        Image(
                            painter = painterResource(id = R.drawable.conversa),
                            contentDescription = "projetos",
                            modifier = Modifier
                                .height(25.dp)
                                .width(25.dp))
                    }

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
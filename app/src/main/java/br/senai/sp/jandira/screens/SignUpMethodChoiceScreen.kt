package br.senai.sp.jandira.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.ui.theme.BalooTammudu

@Composable
fun SignUpMethodChoiceScreen(navController: NavController) {

    Surface (
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xffFFFFFF)
    ){

       Column (
           modifier = Modifier.fillMaxSize()
       ){

           Column (
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(top = 100.dp, bottom = 50.dp),
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
               modifier = Modifier.fillMaxWidth(),
               horizontalAlignment = Alignment.CenterHorizontally
           ){

               Card(
                   onClick = {

                   },
                   modifier = Modifier
                       .height(150.dp)
                       .width(150.dp),
                   colors = CardDefaults.cardColors(
                       containerColor = Color(0xffFEFEFE)
                   ),
                   border = BorderStroke(2.dp, Brush.linearGradient(
                       0.0f to Color(0xff011F4B),
                       1.0f to Color(0xff066FD2)
                   ))
               ) {

                   Column (
                       modifier = Modifier.fillMaxSize().padding(10.dp),
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.SpaceBetween
                   ){
                       Image(
                           painter = painterResource(id = R.drawable.client),
                           contentDescription = "client",
                           modifier = Modifier
                               .height(80.dp)
                               .width(80.dp)
                       )
                       Text(
                           text = stringResource(id = R.string.client),
                           fontSize = 18.sp,
                           fontFamily = BalooTammudu,
                           color = Color(0xff03396C)
                       )
                   }
               }

               Spacer(modifier = Modifier.height(50.dp))
               Card(
                   onClick = {
                       navController.navigate("FreelancerSignUp" +
                               "")
                   },
                   modifier = Modifier
                       .height(150.dp)
                       .width(150.dp),
                   colors = CardDefaults.cardColors(
                       containerColor = Color(0xffFEFEFE)
                   ),
                   border = BorderStroke(2.dp, Brush.linearGradient(
                       0.0f to Color(0xff011F4B),
                       1.0f to Color(0xff066FD2)
                   ))
               ) {

                   Column (
                       modifier = Modifier.fillMaxSize().padding(10.dp),
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.SpaceBetween
                   ){
                       Image(
                           painter = painterResource(id = R.drawable.freelancer),
                           contentDescription = "freelancer",
                           modifier = Modifier
                               .height(80.dp)
                               .width(80.dp)
                       )
                       Text(
                           text = stringResource(id = R.string.freelancer),
                           fontSize = 18.sp,
                           fontFamily = BalooTammudu,
                           color = Color(0xff03396C)
                       )
                   }
               }



           }

       }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun SigUpPreview() {

}
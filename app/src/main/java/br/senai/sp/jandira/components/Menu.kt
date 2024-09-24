package br.senai.sp.jandira.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.R

@Composable
fun Menu() {

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(
                Brush.linearGradient(
                    0.0f to Color(0xff03396C),
                    1.0f to Color(0xff011F4B)
                )
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(15.dp)
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

@Preview (showBackground = true)
@Composable
private fun MenuPreview() {
    Menu()
}
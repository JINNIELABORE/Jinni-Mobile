package br.senai.sp.jandira.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.R

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
            Text(text = "Sucesso")

            Image(
                painter = painterResource(id = R.drawable.sucess),
                contentDescription = "sucesso")
        }
    }
}
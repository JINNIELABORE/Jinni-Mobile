package br.senai.sp.jandira.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.ui.theme.BalooTammudu
import br.senai.sp.jandira.ui.theme.Poppins

@Composable
fun GradientButton(
    onClick: () -> Unit,
    text: String
) {



    Button(
        onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(
                Brush.linearGradient(
                    0.0f to Color(0xff011F4B),
                    1.0f to Color(0xff03396C)
                ),
                shape = RoundedCornerShape(10.dp)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Text(
            text = text,
            color = Color(0xffFFFFFF),
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp)
    }
}

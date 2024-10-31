package br.senai.sp.jandira.ui.theme

import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import br.senai.sp.jandira.R


val Poppins = FontFamily(
    Font(R.font.poppins, weight = FontWeight.Normal),
    Font(R.font.poppins_medium, weight = FontWeight.Medium),
    Font(R.font.poppins_semibold, weight = FontWeight.SemiBold)
)

val Tamma = FontFamily(
    Font(
        R.font.baloo_tamma,
        weight = FontWeight.Normal
    )
)

val BalooTammudu = FontFamily(
    Font(R.font.tammudumedium, FontWeight.Medium),
    Font(R.font.tammuduregular, FontWeight.Normal),
    Font(R.font.tammudusemibold, FontWeight.SemiBold),
)
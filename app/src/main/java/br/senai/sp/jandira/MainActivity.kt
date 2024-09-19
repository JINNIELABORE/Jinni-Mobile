package br.senai.sp.jandira

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.screens.AddCnpj
import br.senai.sp.jandira.screens.ClientSignUp
import br.senai.sp.jandira.screens.FirstPageScreen
import br.senai.sp.jandira.screens.FreelancerSignUp
import br.senai.sp.jandira.screens.SignUpMethodChoiceScreen
import br.senai.sp.jandira.ui.theme.JinniTheme
import br.senai.sp.jandira.viewmodel.ClientViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JinniTheme {

                val  navController = rememberNavController()
                val clientViewModel = ClientViewModel()
                NavHost(
                    navController = navController,
                    startDestination = "FirstPage"
                ){
                    composable(route = "FirstPage") { FirstPageScreen(navController) }
                    composable(route = "SignUpMethod") { SignUpMethodChoiceScreen(navController) }
                    composable(route = "FreelancerSignUp") { FreelancerSignUp(navController) }
                    composable(route = "ClientSignUp") { ClientSignUp(navController, clientViewModel = clientViewModel ) }
                    composable(route = "AddCnpj") { AddCnpj(navController , clientViewModel = clientViewModel)}
                }
                
            }
        }
    }
}


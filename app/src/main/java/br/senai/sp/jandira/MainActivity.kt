package br.senai.sp.jandira

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.screens.cadastros.AddCnpj
import br.senai.sp.jandira.screens.cadastros.BirthdayScreen
import br.senai.sp.jandira.screens.chat.ChatListScreen
import br.senai.sp.jandira.screens.client.ClientHomeScreen
import br.senai.sp.jandira.screens.cadastros.ClientSignUp
import br.senai.sp.jandira.screens.freelancer.FreelanceHomeScreen
import br.senai.sp.jandira.screens.freelancer.FreelancerProfile
import br.senai.sp.jandira.screens.cadastros.FreelancerSignUp
import br.senai.sp.jandira.screens.cadastros.LoginScreen
import br.senai.sp.jandira.screens.ProjectsScreen
import br.senai.sp.jandira.screens.cadastros.SignUpMethodChoiceScreen
import br.senai.sp.jandira.screens.cadastros.Sucess
import br.senai.sp.jandira.screens.chat.Chating
import br.senai.sp.jandira.screens.client.ClientProfile
import br.senai.sp.jandira.ui.theme.JinniTheme
import br.senai.sp.jandira.viewmodel.ClientViewModel
import br.senai.sp.jandira.viewmodel.FreelancerViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JinniTheme {

                val  navController = rememberNavController()
                val clientViewModel = ClientViewModel()
                val freelancerViewModel = FreelancerViewModel()
                NavHost(
                    navController = navController,
                    startDestination = "Login",
                ){

                    composable(route = "Login") { LoginScreen(navController) }
                    composable(route = "SignUpMethod") { SignUpMethodChoiceScreen(navController) }
                    composable(route = "FreelancerSignUp") { FreelancerSignUp(navController, freelancerViewModel = freelancerViewModel) }
                    composable(route = "ClientSignUp") { ClientSignUp(navController, clientViewModel = clientViewModel ) }
                    composable(route = "AddCnpj") { AddCnpj(navController , clientViewModel = clientViewModel) }
                    composable(route = "SuccessScreen") { Sucess() }


                    composable(route = "ChatList"){ ChatListScreen(navController) }
                    composable(route = "ProjectsScreen"){ ProjectsScreen() }
                    composable(route = "Birthday"){ BirthdayScreen(freelancerViewModel, navController) }

                    //CLIENT
                    composable(route = "ClientHome"){ ClientHomeScreen() }
                    composable(route = "ClientProfile"){ ClientProfile(navController) }



                    //FREELANCER
                    composable(route = "FreelancerProfile"){ FreelancerProfile() }
                    composable(route = "FreelancerHome"){ FreelanceHomeScreen() }


                    //CHAT
                    composable(route = "Chat") { Chating() }



                    }
                }
                
            }
        }
    }



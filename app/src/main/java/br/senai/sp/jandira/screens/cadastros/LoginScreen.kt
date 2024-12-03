package br.senai.sp.jandira.screens.cadastros

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.components.GradientButton
import br.senai.sp.jandira.model.Client
import br.senai.sp.jandira.model.Freelancer
import br.senai.sp.jandira.model.ResultLogin
import br.senai.sp.jandira.service.RetrofitFactory
import br.senai.sp.jandira.ui.theme.BalooTammudu
import br.senai.sp.jandira.ui.theme.Poppins
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen(navController: NavController) {
    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    var client by remember { mutableStateOf<ResultLogin?>(null) }
    var freelancer by remember { mutableStateOf<Freelancer?>(null) }
    var loginError by remember { mutableStateOf(false) }  // Controle de erro
    val context = LocalContext.current

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.genius), contentDescription = "logo")
                Text(
                    text = "Jinni",
                    fontSize = 64.sp,
                    fontFamily = BalooTammudu,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        brush = Brush.linearGradient(
                            listOf(Color(0xff011F4B), Color(0xff005B96))
                        )
                    )
                )
            }

            Column(modifier = Modifier.padding(horizontal = 35.dp, vertical = 30.dp)) {
                // Campos de email e senha
                OutlinedTextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                    shape = RoundedCornerShape(10.dp),
                    placeholder = { Text(text = stringResource(id = R.string.email)) },
                    leadingIcon = {
                        Icon(imageVector = Icons.Outlined.Email, contentDescription = "Email")
                    }
                )

                OutlinedTextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                    shape = RoundedCornerShape(10.dp),
                    placeholder = { Text(text = stringResource(id = R.string.password)) },
                    leadingIcon = {
                        Icon(imageVector = Icons.Outlined.Lock, contentDescription = "Password")
                    }
                )

                // Mensagem de erro
                if (loginError) {
                    Text(
                        text = "Erro ao realizar login. Tente novamente.",
                        color = Color.Red,
                        modifier = Modifier.padding(top = 10.dp),
                        fontSize = 14.sp
                    )
                }

                // Botão de login
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 60.dp, vertical = 45.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Button(
                        onClick = {
                            if (email.value.isNotEmpty() && password.value.isNotEmpty()) {
                                loginError = false  // Reseta o erro antes de iniciar o login

                                // Primeira tentativa: busca por cliente
                                val callClient = RetrofitFactory().createClientService()
                                    .getClientByEmail(email.value)

                                callClient.enqueue(object : Callback<ResultLogin> {
                                    override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
                                        if (response.isSuccessful) {
                                            val result = response.body()
                                            if (result != null && result.nome.isNotEmpty()) {
                                                client = result
                                                // Verifica se o email e senha correspondem ao cliente
                                                if (client?.nome?.first()?.email_cliente == email.value && client?.nome?.first()?.senha_cliente == password.value) {
                                                    navController.navigate("ClientHome")
                                                    return
                                                }
                                            }
                                        }

                                        // Caso o cliente não seja encontrado, tenta buscar freelancer
                                        loginAsFreelancer(email.value, password.value, navController, context)
                                    }

                                    override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                                        Log.e("Login Error", t.message.toString())
                                        // Caso erro ao buscar o cliente, tenta freelancer
                                        loginAsFreelancer(email.value, password.value, navController, context)
                                    }
                                })
                            }
                        },
                        modifier = Modifier.fillMaxWidth().height(45.dp).background(
                            Brush.linearGradient(listOf(Color(0xff011F4B), Color(0xff03396C))),
                            shape = RoundedCornerShape(10.dp)
                        ),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Text(
                            text = stringResource(id = R.string.continue_),
                            color = Color(0xffFFFFFF),
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}

// Função para tentar login como freelancer
private fun loginAsFreelancer(email: String, password: String, navController: NavController, context: Context) {
    val callFreelancer = RetrofitFactory().createFreelancerService()
        .getFreelancerByEmail(email)

    callFreelancer.enqueue(object : Callback<ResultLogin> {
        override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
            if (response.isSuccessful) {
                val result = response.body()
                if (result != null && result.nome.isNotEmpty()) {
                    if (result.nome.first().email_freelancer == email && result.nome.first().senha_freelancer == password) {
                        // Navega para a tela do Freelancer
                        navController.navigate("FreelancerHome")
                    } else {
                        // Caso o login não seja bem-sucedido
                        Toast.makeText(context, "Email ou senha incorretos", Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                // Caso erro ao realizar login como freelancer
                Toast.makeText(context, "Erro ao realizar login como freelancer", Toast.LENGTH_LONG).show()
            }
        }

        override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
            Log.e("Freelancer Login Error", t.message.toString())
            Toast.makeText(context, "Erro ao realizar login", Toast.LENGTH_LONG).show()
        }
    })
}











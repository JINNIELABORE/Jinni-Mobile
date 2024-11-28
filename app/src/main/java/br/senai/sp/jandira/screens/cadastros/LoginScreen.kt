package br.senai.sp.jandira.screens.cadastros

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
import br.senai.sp.jandira.service.RetrofitFactory
import br.senai.sp.jandira.ui.theme.BalooTammudu
import br.senai.sp.jandira.ui.theme.Poppins
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen(navController: NavController) {

    var email = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }
    var freelancer by remember {
        mutableStateOf(Freelancer())
    }
    var client by remember {
        mutableStateOf(Client())
    }
    val context = LocalContext.current





    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.genius),
                    contentDescription = "logo"
                )

                Text(
                    text = "Jinni",
                    fontSize = 64.sp,
                    fontFamily = BalooTammudu,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        brush = Brush.linearGradient(
                            listOf(
                                Color(0xff011F4B),
                                Color(0xff005B96)
                            )
                        )
                    )
                )
            }


            Column(
                modifier = Modifier.padding(horizontal = 35.dp, vertical = 30.dp)
            ) {

                OutlinedTextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    shape = RoundedCornerShape(10.dp),
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.email),
                            color = Color(0xff222222),
                            fontFamily = Poppins,
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = "Email",
                            tint = Color(0xff222222)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xffE5E5E5),
                        unfocusedContainerColor = Color(0xffE5E5E5),
                        focusedBorderColor = Color(0xff000000),
                        unfocusedBorderColor = Color.Transparent,
                        focusedTextColor = Color(0xff222222),
                        unfocusedTextColor = Color(0xff222222),
                    ),
                    maxLines = 1
                )

                OutlinedTextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    shape = RoundedCornerShape(10.dp),
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.password),
                            color = Color(0xff222222),
                            fontFamily = Poppins,
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "Password",
                            tint = Color(0xff222222)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xffE5E5E5),
                        unfocusedContainerColor = Color(0xffE5E5E5),
                        focusedBorderColor = Color(0xff000000),
                        unfocusedBorderColor = Color.Transparent,
                        focusedTextColor = Color(0xff222222),
                        unfocusedTextColor = Color(0xff222222),
                    ),
                    maxLines = 1
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = stringResource(id = R.string.signup_text),
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        color = Color(0xff000000)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = stringResource(id = R.string.sign_up),
                        fontFamily = Poppins,
                        color = Color(0xff011F4B),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.clickable { navController.navigate("SignUpMethod") }
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 60.dp, vertical = 45.dp),
                verticalArrangement = Arrangement.Bottom
            ) {

                if (email.value.isNotEmpty() && password.value.isNotEmpty()) {
                    Button(
                        onClick = {
                            if (email.value.isNotEmpty() && password.value.isNotEmpty()) {

                                val callClient = RetrofitFactory().createClientService()
                                    .getClientByEmail(email.value)




                                callClient.enqueue(object : Callback<Client> {
                                    override fun onResponse(
                                        p0: Call<Client>,
                                        p1: Response<Client>
                                    ) {
                                        client = p1.body()!!
                                        Log.i("Entrou no cliente", p1.isSuccessful.toString())
                                        Log.i("$client", client.toString())
                                        if (client.email_cliente == email.value && client.senha_cliente == password.value) {
                                            navController.navigate("ClientHome")
                                        }
                                    }

                                    override fun onFailure(p0: Call<Client>, p1: Throwable) {
                                        Log.i("Cliente erro", p1.message.toString())
                                        Toast.makeText(context, "Não foi possível realizar o login", Toast.LENGTH_LONG).show()
                                    }
                                })

                                val callFreelancer = RetrofitFactory().createFreelancerService()
                                    .getFreelancerByEmail(email.value)

                                callFreelancer.enqueue(object : Callback<Freelancer> {
                                    override fun onResponse(
                                        p0: Call<Freelancer>,
                                        p1: Response<Freelancer>
                                    ) {
                                        freelancer = p1.body()!!
                                        Log.i("Entrou no freelancer", p1.isSuccessful.toString())
                                        Log.i("$freelancer", freelancer.toString())
                                        if (freelancer.email_freelancer == email.value && freelancer.senha_freelancer == password.value) {
                                            navController.navigate("FreelancerHome")
                                        }

                                    }

                                    override fun onFailure(p0: Call<Freelancer>, p1: Throwable) {
                                        Log.i("Freelancer erro", p1.message.toString())
                                        Toast.makeText(context, "Não foi possível realizar o login", Toast.LENGTH_LONG).show()
                                    }

                                })

                            }
                        },
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
                            text = stringResource(id = R.string.continue_),
                            color = Color(0xffFFFFFF),
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp
                        )
                    }
                } else {

                    Button(
                        onClick = {
                            Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(45.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xffE4E4E4)
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.continue_),
                            color = Color(0xff979797),
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








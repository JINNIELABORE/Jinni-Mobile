package br.senai.sp.jandira.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.components.GradientButton
import br.senai.sp.jandira.model.Client
import br.senai.sp.jandira.model.Freelancer
import br.senai.sp.jandira.model.Results
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



    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color(0xffFFFFFF)
    ){

        Column (
            modifier = Modifier.fillMaxSize()
        ){

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 65.dp, start = 10.dp)
            ){
                IconButton(onClick = {
                    navController.navigate("FirstPage")
                }) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBackIosNew,
                        contentDescription = "seta",
                        tint = Color(0xff011F4B)
                    )
                }
            }

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = stringResource(id = R.string.sign_in),
                    fontSize = 24.sp,
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

            Column (
                modifier = Modifier.padding(horizontal = 35.dp, vertical = 30.dp)
            ){

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
                        focusedTextColor = Color(0xff222222)
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
                        focusedTextColor = Color(0xff222222)
                    ),
                    maxLines = 1
                )

                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    Text(
                        text = stringResource(id = R.string.signup_text),
                        fontFamily = Poppins,
                        fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = stringResource(id = R.string.sign_up),
                        fontFamily = Poppins,
                        color = Color(0xff011F4B),
                        fontSize = 12.sp,
                        modifier = Modifier.clickable { navController.navigate("SignUpMethod") }
                    )
                }
            }

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 60.dp, vertical = 35.dp),
                verticalArrangement = Arrangement.Bottom
            ){


                GradientButton(onClick = {

                    Login(navController, email.value, password.value)
                }, text = stringResource(id = R.string.continue_))
            }


        }
    }

}

@Composable
fun Login(navController: NavController, email: String, password: String) {

    if(email.isEmpty() || password.isEmpty()){

    }
    else{

        var client by remember {
            mutableStateOf(Client())
        }
        val callClient = RetrofitFactory().createClientService().getClientByEmail(email)

        callClient.enqueue(object : Callback<Client> {
            override fun onResponse(p0: Call<Client>, p1: Response<Client>) {
                client = p1.body()!!
            }

            override fun onFailure(p0: Call<Client>, p1: Throwable) {

            }
        })

        var freelancer by remember {
            mutableStateOf(Freelancer())
        }
        val callFreelancer = RetrofitFactory().createFreelancerService().getFreelancerByEmail(email)

        callFreelancer.enqueue(object : Callback<Freelancer> {
            override fun onResponse(p0: Call<Freelancer>, p1: Response<Freelancer>) {
                freelancer = p1.body()!!
            }

            override fun onFailure(p0: Call<Freelancer>, p1: Throwable) {

            }

        })

        if(client.email_cliente == email && client.senha_cliente == password){
            navController.navigate("ClientHome")
        } else if (freelancer.email_freelancer == email && freelancer.senha_freelancer == password){
            navController.navigate("FreelancerHome")
        }

    }
}


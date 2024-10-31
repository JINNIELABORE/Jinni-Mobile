package br.senai.sp.jandira.screens.cadastros

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Numbers
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.components.GradientButton
import br.senai.sp.jandira.model.Freelancer
import br.senai.sp.jandira.service.RetrofitFactory
import br.senai.sp.jandira.ui.theme.BalooTammudu
import br.senai.sp.jandira.ui.theme.Poppins
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun FreelancerSignUp(navController: NavController) {

    val context = LocalContext.current
    val retrofitFactory = RetrofitFactory()
    
    var freelancerName = remember {
        mutableStateOf("")
    }

    var freelancerEmail = remember {
        mutableStateOf("")
    }

    var freelancerPassword = remember {
        mutableStateOf("")
    }

    var freelancerConfirmPassword = remember {
        mutableStateOf("")
    }
    var freelancerCpf = remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()

    ) {
        
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            
            Row (
                modifier = Modifier.fillMaxWidth().padding(top = 65.dp, start = 10.dp)
            ){
                IconButton(onClick = {
                    navController.navigate("SignUpMethod")
                }) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBackIosNew,
                        contentDescription = "seta",
                        tint = Color(0xff011F4B)
                    )
                }
            }

            Column (
                modifier = Modifier.fillMaxWidth()
            ){

                Column (
                    modifier = Modifier.padding(horizontal = 35.dp)
                ){
                    Text(
                        text = stringResource(id = R.string.get_started),
                        fontSize = 32.sp,
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

                    Text(
                        text = stringResource(id = R.string.get_started_text),
                        fontSize = 12.sp,
                        fontFamily = Poppins,
                        color = Color(0xff6F6F6F))
                }

                Column (
                    modifier = Modifier
                        .padding(horizontal = 35.dp, vertical = 30.dp)
                ){

                    OutlinedTextField(
                        value = freelancerName.value,
                        onValueChange = { freelancerName.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        shape = RoundedCornerShape(10.dp),
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.name),
                                color = Color(0xff222222),
                                fontFamily = Poppins,
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Person,
                                contentDescription = "Name",
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
                        value = freelancerEmail.value,
                        onValueChange = {freelancerEmail.value = it},
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
                        value = freelancerPassword.value,
                        onValueChange = { freelancerPassword.value = it },
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

                    OutlinedTextField(
                        value = freelancerConfirmPassword.value,
                        onValueChange = { freelancerConfirmPassword.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        shape = RoundedCornerShape(10.dp),
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.confirm_password),
                                color = Color(0xff222222),
                                fontFamily = Poppins,
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Lock,
                                contentDescription = "Confirm Password",
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
                        value = freelancerCpf.value,
                        onValueChange = { freelancerCpf.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        shape = RoundedCornerShape(10.dp),
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.cpf),
                                color = Color(0xff222222),
                                fontFamily = Poppins,
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Numbers,
                                contentDescription = "CPF",
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

                   
                }

                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 60.dp, vertical = 35.dp),
                    verticalArrangement = Arrangement.Bottom
                ){

                    GradientButton(onClick = {

                        if(
                            (freelancerName.value.isNotEmpty() && freelancerEmail.value.isNotEmpty() && freelancerPassword.value.isNotEmpty() && freelancerConfirmPassword.value.isNotEmpty()) &&
                            (freelancerPassword.value == freelancerConfirmPassword.value)){

                            val freelancer = Freelancer(
                                nome_freelancer = freelancerName.value,
                                email_freelancer = freelancerEmail.value,
                                senha_freelancer = freelancerPassword.value,
                                cpf_freelancer = freelancerCpf.value
                            )
                            val freelancerService = retrofitFactory.createFreelancerService()

                            freelancerService.postFreelancer(freelancer).enqueue(object : Callback<Freelancer> {

                                override fun onResponse(
                                    call: Call<Freelancer>,
                                    response: Response<Freelancer>
                                ) {
                                    if (response.isSuccessful){
                                        navController.navigate("SucessScreen")
                                    }else{
                                        // erro
                                    }
                                }

                                override fun onFailure(p0: Call<Freelancer>, p1: Throwable) {

                                }
                            })


                        }

                    },
                        text = stringResource(id = R.string.continue_)
                    )
                }


            }
        }


    }
}

package br.senai.sp.jandira.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.components.GradientButton
import br.senai.sp.jandira.ui.theme.BalooTammudu
import br.senai.sp.jandira.ui.theme.Poppins
import br.senai.sp.jandira.viewmodel.ClientViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import br.senai.sp.jandira.model.Client
import br.senai.sp.jandira.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun AddCnpj(navController: NavController, clientViewModel: ClientViewModel) {

    var cnpj by remember { mutableStateOf("") }
    val context = LocalContext.current
    val retrofitFactory = RetrofitFactory()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xffFFFFFF)
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 65.dp, start = 30.dp)
            ) {
                IconButton(onClick = {
                    navController.navigate("SignUpMethod")
                }) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "seta",
                        tint = Color(0xff011F4B)
                    )
                }
            }

            Column(modifier = Modifier.fillMaxWidth()) {

                Column(modifier = Modifier.padding(horizontal = 35.dp)) {
                    Text(
                        text = stringResource(id = R.string.add_cnpj),
                        fontSize = 32.sp,
                        fontFamily = BalooTammudu,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xff011F4B)
                    )

                    Text(
                        text = stringResource(id = R.string.add_cnpj_text),
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        color = Color(0xff6F6F6F)
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(horizontal = 35.dp, vertical = 30.dp)
                ) {

                    OutlinedTextField(
                        value = cnpj,
                        onValueChange = { cnpj = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        shape = RoundedCornerShape(10.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.cnpj),
                                color = Color(0xff222222),
                                fontFamily = Poppins
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color(0xffFBFBFB),
                            unfocusedContainerColor = Color(0xffFBFBFB),
                            focusedBorderColor = Color(0xff000000),
                            unfocusedBorderColor = Color(0xff6F6F6F),
                            focusedTextColor = Color(0xff222222)
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        )
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 60.dp)
                ) {

                    GradientButton(
                        onClick = {
                            if (cnpj.isNotEmpty()) {
                                clientViewModel.addCnpj(cnpj)
                                val client = clientViewModel.clientData.value

                                // Create the service instance
                                val clientService = retrofitFactory.createClientService()

                                // Perform the network call
                                clientService.postClient(client).enqueue(object : Callback<Client> {
                                    override fun onResponse(
                                        call: Call<Client>,
                                        response: Response<Client>
                                    ) {
                                        if (response.isSuccessful) {
                                            // Navegue para a próxima tela
                                            navController.navigate("SuccessScreen")
                                        } else {
                                            // Trate o erro de resposta
                                        }
                                    }

                                    override fun onFailure(call: Call<Client>, t: Throwable) {
                                        // Trate a falha na chamada
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

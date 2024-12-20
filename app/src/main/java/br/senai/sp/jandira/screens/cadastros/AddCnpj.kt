package br.senai.sp.jandira.screens.cadastros

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.CorporateFare
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
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
    val maxChar = 14

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 10.dp)
            ) {
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

            Column(modifier = Modifier.fillMaxWidth()) {

                Column(modifier = Modifier.padding(horizontal = 35.dp)) {
                    Text(
                        text = stringResource(id = R.string.add_cnpj),
                        fontSize = 24.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
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
                        onValueChange = { if(it.length <= maxChar) cnpj = it},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        shape = RoundedCornerShape(10.dp),
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.cnpj),
                                color = Color(0xff222222),
                                fontFamily = Poppins,
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.CorporateFare,
                                contentDescription = "CNPJ",
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
                        maxLines = 1,
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

                    if(cnpj.isNotEmpty() && cnpj.length == maxChar){
                        Button(
                            onClick = {
                                if(cnpj.isNotEmpty()){

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
                                                Log.i("response", response.toString())
                                                navController.navigate("SuccessScreen")
                                            } else {
                                                // Trate o erro de resposta

                                                Log.i("response", response.toString())                                        }
                                        }

                                        override fun onFailure(call: Call<Client>, t: Throwable) {
                                            // Trate a falha na chamada
                                            Log.i("response", t.toString())
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
                                fontSize = 18.sp)
                        }
                    }
                    else{

                        Button(
                            onClick = {
                                Toast.makeText(context, "Preencha o campo corretamente", Toast.LENGTH_SHORT).show()
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
                                fontSize = 18.sp)
                        }
                    }


                }
            }
        }
    }
}



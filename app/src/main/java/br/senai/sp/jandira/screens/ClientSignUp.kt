package br.senai.sp.jandira.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.components.GradientButton
import br.senai.sp.jandira.ui.theme.BalooTammudu
import br.senai.sp.jandira.ui.theme.Gradient
import br.senai.sp.jandira.ui.theme.Poppins
import br.senai.sp.jandira.viewmodel.ClientViewModel

@Composable
fun ClientSignUp(navController: NavController, clientViewModel: ClientViewModel) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 65.dp, start = 10.dp)
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
                        text = stringResource(id = R.string.add_info),
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
                        color = Color(0xff6F6F6F)
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(horizontal = 35.dp, vertical = 30.dp)
                ) {

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it},
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
                        value = email,
                        onValueChange = { email = it },
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
                        value = password,
                        onValueChange = { password = it },
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
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it},
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

                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 60.dp)
                ) {

                    GradientButton(onClick = {
                        clientViewModel.setClientData(name, email, password, confirmPassword)
                        navController.navigate("AddCnpj")
                    },
                        text = stringResource(id = R.string.continue_)
                    )
                }

            }
        }
    }
}

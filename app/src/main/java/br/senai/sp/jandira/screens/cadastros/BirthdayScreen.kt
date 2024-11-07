package br.senai.sp.jandira.screens.cadastros

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.components.GradientButton
import br.senai.sp.jandira.ui.theme.BalooTammudu
import br.senai.sp.jandira.ui.theme.Poppins
import br.senai.sp.jandira.viewmodel.FreelancerViewModel
import kotlinx.datetime.LocalDate
import network.chaintech.kmp_date_time_picker.ui.datepicker.WheelDatePickerView
import network.chaintech.kmp_date_time_picker.utils.DateTimePickerView
import network.chaintech.kmp_date_time_picker.utils.now

@Composable
fun BirthdayScreen(navController: NavController, freelancerViewModel: FreelancerViewModel) {

    var showDatePicker by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }


    var datanasc = remember {
        mutableStateOf("")
    }

    Surface (
        modifier = Modifier
            .fillMaxSize()
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
        ){

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


            Column (
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 35.dp)) {
                    Text(
                        text = stringResource(id = R.string.get_started),
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
                        text = stringResource(id = R.string.add_birthday),
                        fontSize = 12.sp,
                        fontFamily = Poppins,
                        color = Color(0xff6F6F6F)
                    )

                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 70.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.party),
                            contentDescription = "cake",
                            modifier = Modifier
                                .size(150.dp))
                    }


                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){

                        OutlinedTextField(
                            value = datanasc.value,
                            onValueChange = {
                                datanasc.value = it
                            },
                            modifier = Modifier
                                .width(220.dp)
                                .padding(vertical = 5.dp),
                            shape = RoundedCornerShape(10.dp),
                            placeholder = {
                                Text(
                                    text = stringResource(id = R.string.birthday),
                                    color = Color(0xff222222),
                                    fontFamily = Poppins,
                                )
                            },
                            readOnly = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = Color(0xffE5E5E5),
                                unfocusedContainerColor = Color(0xffE5E5E5),
                                focusedBorderColor = Color(0xff000000),
                                unfocusedBorderColor = Color.Transparent,
                                focusedTextColor = Color(0xff222222)
                            ),
                            maxLines = 1,
                            textStyle = TextStyle(
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp
                            )
                        )

                        WheelDatePickerView(
                            showDatePicker = showDatePicker,
                            height = 200.dp,
                            title = stringResource(id = R.string.birthday),
                            titleStyle = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = BalooTammudu,
                                fontWeight = FontWeight.Medium,
                                brush = Brush.linearGradient(
                                    listOf(
                                        Color(0xff011F4B),
                                        Color(0xff005B96)
                                    )
                                )
                            ),
                            dateTimePickerView = DateTimePickerView.DIALOG_VIEW,
                            rowCount = 3,
                            dateTextStyle = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Normal
                            ),
                            yearsRange = 1920..LocalDate.now().year,
                            onDoneClick = {
                                showDatePicker = false
                                println("Done: $it")
                                datanasc.value = it.toString()

                            },
                            onDismiss = {
                                showDatePicker = false
                                println("Dismissed.")
                            })

                        Card (
                            modifier = Modifier
                                .height(55.dp)
                                .width(55.dp)
                                .clickable {
                                    showDatePicker = true
                                }
                                .background(
                                    brush = Brush.linearGradient(
                                        listOf(
                                            Color(0xff011F4B),
                                            Color(0xff005B96)
                                        )
                                    ),
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Transparent
                            )
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Icon(
                                    imageVector = Icons.Outlined.CalendarMonth,
                                    contentDescription = "Name",
                                    tint = Color(0xffFFFFFF),
                                    modifier = Modifier
                                        .size(25.dp)
                                )
                            }
                        }


                    }










                }
            }









        }

        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 60.dp, vertical = 35.dp),
            verticalAlignment = Alignment.Bottom
        ){

            GradientButton(
                onClick = {

                    if(datanasc.value.isNotEmpty()){
                        FreelancerViewModel().addBirthday(datanasc.value)
                        navController.navigate("FreelancerSignUp")
                    }
                },
                text = stringResource(id = R.string.continue_)
            )


        }
    }

}


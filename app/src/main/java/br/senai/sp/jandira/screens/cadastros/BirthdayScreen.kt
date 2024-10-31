package br.senai.sp.jandira.screens.cadastros

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.R
import br.senai.sp.jandira.ui.theme.BalooTammudu
import br.senai.sp.jandira.ui.theme.Poppins
import kotlinx.datetime.LocalDate
import network.chaintech.kmp_date_time_picker.ui.datepicker.WheelDatePickerView
import network.chaintech.kmp_date_time_picker.utils.DateTimePickerView
import network.chaintech.kmp_date_time_picker.utils.now

@Composable
fun BirthdayScreen() {

    var showDatePicker by remember { mutableStateOf(false) }

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
 //                   navController.navigate("SignUpMethod")
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
                Column(modifier = Modifier.padding(horizontal = 35.dp)) {
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
                        text = stringResource(id = R.string.add_birthday),
                        fontSize = 12.sp,
                        fontFamily = Poppins,
                        color = Color(0xff6F6F6F)
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = { },
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

                    WheelDatePickerView(
                        showDatePicker = showDatePicker,
                        height = 300.dp,
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
                        dateTimePickerView = DateTimePickerView.BOTTOM_SHEET_VIEW,
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
                        },
                        onDismiss = {
                            showDatePicker = false
                            println("Dismissed.")
                        })

                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = { showDatePicker = true }) {
                        
                    }

                }
            }









        }
    }

}

@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun Bday() {
    BirthdayScreen()
}
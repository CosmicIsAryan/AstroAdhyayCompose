package com.example.astroadhyaycompose.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.spr.jetpack_loading.components.indicators.LineSpinFadeLoaderIndicator
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun kundli() {

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 60.dp, start = 20.dp, end = 20.dp, bottom = 40.dp)
            .verticalScroll(rememberScrollState())
            .imePadding()



    ){
        TopBarBackwithTitle("Kundli")
        Spacer(modifier = Modifier.height(40.dp))
        kundliInput()


    }



}

@Composable
fun TopBarBackwithTitle(title: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = "back",
            tint = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.
            clickable {

            }
        )
        Text(
            text = title,
            fontSize = 26.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 20.dp)

        )
        Spacer(modifier = Modifier.weight(1f, fill = false))


    }

}



@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Preview
@Composable
fun kundliInput(
){
        var name by rememberSaveable {
            mutableStateOf("")
        }
        var location by rememberSaveable {
            mutableStateOf("")
        }
        var date by remember{
            mutableStateOf(LocalDate.now())
        }
        var time by rememberSaveable {
            mutableStateOf(LocalTime.NOON)
        }
        val formatedDate by remember {
           derivedStateOf {
               DateTimeFormatter.ofPattern("dd-MM-yyyy").format(date)
           }
        }
        val formatedTime by remember {

            derivedStateOf {
                DateTimeFormatter.ofPattern("hh:mm").format(time)
            }

        }
    var dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()
        val color = MaterialTheme.colorScheme.primary
        var selectedGender by remember { mutableStateOf<String?>(null) }

        // Define colors for selected and unselected states
        val selectedColor by animateColorAsState(
            targetValue = if (selectedGender != null) MaterialTheme.colorScheme.primary else androidx.compose.ui.graphics.Color.DarkGray
        )
        val unselectedColor by animateColorAsState(
            targetValue = androidx.compose.ui.graphics.Color.DarkGray
        )

        // Define sizes for selected and unselected states
        val selectedPadding by animateDpAsState(
            targetValue = if (selectedGender != null) 8.dp else 8.dp
        )
        val unselectedPadding by animateDpAsState(
            targetValue = 8.dp
        )


        Column() {

            OutlinedTextField(

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = color
                    ,
                    focusedLabelColor = color),


                value = name,
                shape = RoundedCornerShape(10.dp),
                onValueChange = {name = it},label = {
                    Text(text = "Name" ,  fontWeight = FontWeight.SemiBold) },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 40.dp, end = 20.dp, bottom = 20.dp)

            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment =  Alignment.CenterHorizontally

                ) {
                    Text(text = "Date Of Birth" , color = MaterialTheme.colorScheme.onBackground ,
                        modifier = Modifier.padding(bottom = 10.dp))

                    Button(onClick = {
                        dateDialogState.show()
                    } ,
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = (MaterialTheme.colorScheme.onBackground),
                            contentColor = MaterialTheme.colorScheme.background
                        ),
                        modifier = Modifier
                            .padding(horizontal = 20.dp,)
                            .width(150.dp),
                        shape =(RoundedCornerShape(10.dp))

                    ) {
                        if(date != null){
                            Text(text = formatedDate)
                        }else Text(text = "Date of Birth")


                    }

                }


                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment =  Alignment.CenterHorizontally

                ) {
                    Text(text = "Time Of Birth" , color = MaterialTheme.colorScheme.onBackground ,
                        modifier = Modifier.padding( bottom = 10.dp))

                    Button(onClick = {
                        timeDialogState.show()
                    }
                        ,
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = (MaterialTheme.colorScheme.onBackground),
                            contentColor = MaterialTheme.colorScheme.background
                        ),
                        modifier = Modifier
                            .padding(horizontal = 20.dp,)
                            .width(150.dp),
                        shape =(RoundedCornerShape(10.dp))
                    ) {
                        if(time != null){
                            Text(text = formatedTime)
                        }else Text(text = "Time Of Birth")

                    }

                }



            }
            MaterialDialog(
                dialogState = dateDialogState,
                buttons = {
                    positiveButton(text = "Ok") {

                    }
                    negativeButton(text = "Cancel")
                }
            ) {
                datepicker(
                    initialDate = LocalDate.now(),
                    title = "Pick a date",

                ) {
                    date = it
                }
            }
            MaterialDialog(
                dialogState = timeDialogState,
                buttons = {
                    positiveButton(text = "Ok") {
                    }
                    negativeButton(text = "Cancel")
                }
            ) {
                timepicker(
                    initialTime = LocalTime.NOON,
                    title = "Pick a time",
                    timeRange = LocalTime.MIDNIGHT..LocalTime.NOON
                ) {
                    time = it
                }
            }


            OutlinedTextField(

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = color,
                    focusedTextColor = MaterialTheme.colorScheme.onBackground
                    ,
                    focusedLabelColor = color),

                value = location,
                shape = RoundedCornerShape(10.dp),
                onValueChange = {location = it},label = {
                    Text(text = "location" ,  fontWeight = FontWeight.SemiBold) },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 20.dp)
            )


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Gender", fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground)

                Spacer(modifier = Modifier.weight(1f))
                GenderOption(
                    label = "Male",
                    isSelected = selectedGender == "Male",
                    onClick = { selectedGender = if (selectedGender == "Male") null else "Male" },
                    selectedColor = selectedColor,
                    unselectedColor = unselectedColor,
                    selectedPadding = selectedPadding,
                    unselectedPadding = unselectedPadding
                )
                GenderOption(
                    label = "Female",
                    isSelected = selectedGender == "Female",
                    onClick = { selectedGender = if (selectedGender == "Female") null else "Female" },
                    selectedColor = selectedColor,
                    unselectedColor = unselectedColor,
                    selectedPadding = selectedPadding,
                    unselectedPadding = unselectedPadding
                )
            }


            ElevatedButton(onClick = {

            },
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = (MaterialTheme.colorScheme.onBackground),
                    contentColor = MaterialTheme.colorScheme.background
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 40.dp
                    )
                    .height(50.dp)
                ,
                shape = RoundedCornerShape(10.dp)
            ) {
                if (false){
                    LineSpinFadeLoaderIndicator(
                        color = MaterialTheme.colorScheme.primary,
                        elementHeight = 15f
                    )
                }else{
                    Text(text = "Submit" , fontSize = 20.sp , fontWeight = FontWeight.Bold  , color = MaterialTheme.colorScheme.background)

                }


            }


        }



}

@Composable
fun GenderOption(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    selectedColor: androidx.compose.ui.graphics.Color,
    unselectedColor: androidx.compose.ui.graphics.Color,
    selectedPadding: Dp,
    unselectedPadding: Dp
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(
                color = if (isSelected) selectedColor else unselectedColor,
                shape = RoundedCornerShape(8.dp)
            )
            .height(60.dp)
            .clickable(onClick = onClick)
            .padding(horizontal = 20.dp)
            .animateContentSize()
            .padding(selectedPadding)

    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.background
        )
    }
}





package com.example.astroadhyaycompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.astroadhyaycompose.viewmodel.FormViewModel
import com.example.treads.navigation.Routes
import com.spr.jetpack_loading.components.indicators.LineSpinFadeLoaderIndicator

@Composable
fun Registration(navHostController: NavHostController){
    FormPage1(navHostController )
}

@Composable
fun FormPage1(navHostController: NavHostController){
    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 60.dp)
            .verticalScroll(rememberScrollState())
            .imePadding()


    ) {
        RegistationTopBar()
        PhoneNumInput()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp)
                .clickable {

                    navHostController.navigate(Routes.Login.routes) {
                        popUpTo(navHostController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }

        ) {
            Text(text = "Already Have a Account /" ,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
            )
            Text(text = "  Login " ,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.weight(0.5f))

        ElevatedButton(onClick = {
            navHostController.navigate(Routes.PageTwo.routes)


        },
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.background
            ),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 14.dp),
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 40.dp, bottom = 80.dp)
                .height(50.dp)





            ,
            shape = RoundedCornerShape(10.dp)
        ) {
            if (false){
                LineSpinFadeLoaderIndicator(
                    color = MaterialTheme.colorScheme.onBackground,
                    elementHeight = 15f
                )
            }else{
                Text(text = "Next" , fontSize = 20.sp , fontWeight = FontWeight.Bold , modifier = Modifier.padding(end = 10.dp))
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = "back" , tint = MaterialTheme.colorScheme.background)

            }


        }




    }

}

@Composable
fun PhoneNumInput (){

    val formViewModel : FormViewModel = viewModel()
    val formData  = formViewModel.formData.collectAsState().value


    val color = MaterialTheme.colorScheme.primary
    OutlinedTextField(

        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = null
            )
        },
        colors = OutlinedTextFieldDefaults. colors(
            focusedBorderColor = color
            ,
            focusedLabelColor = color),

        value = formData.phone,
        shape = RoundedCornerShape(10.dp),
        onValueChange = {formViewModel.updateFormData(formData.copy(phone = it)) },label = {
            Text(text = "Phone Number" ,  fontWeight = FontWeight.SemiBold) },

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 40.dp, start = 40.dp, end = 40.dp)



    )



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageTwo(navHostController: NavHostController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 60.dp)
            .imePadding()
    ) {

        var name by rememberSaveable { mutableStateOf("") }
        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }

        var color = MaterialTheme.colorScheme.primary
        RegistationTopBar()
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = { Text("Name") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color,
                focusedLabelColor = color
            ),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .padding(horizontal = 40.dp, vertical = 10.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
            label = { Text("Email") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color,
                focusedLabelColor = color
            ),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .padding(horizontal = 40.dp, vertical = 10.dp)
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Password,
                    contentDescription = null
                )
            },
            label = { Text("Password") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = color,
                focusedLabelColor = color
            ),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon =
                    if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordVisible) "Hide password" else "Show password"
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = icon, contentDescription = description)
                }
            },
            singleLine = true,
            modifier = Modifier
                .padding(horizontal = 40.dp, vertical = 10.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        ElevatedButton(onClick = {
//        authViewModel.login(email , password , context)

            navHostController.navigate(Routes.BottomNav.routes) {
                popUpTo(navHostController.graph.findStartDestination().id) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        },
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = (MaterialTheme.colorScheme.onBackground),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 40.dp,
                    start = 40.dp,
                    end = 40.dp
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
                Text(text = "Login" , fontSize = 20.sp , fontWeight = FontWeight.Bold  , color = MaterialTheme.colorScheme.background)

            }


        }

    }



}

    @Composable
    fun RegistationTopBar() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 40.dp)
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "back",
                tint = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = "Sign Up",
                fontSize = 26.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 20.dp)

            )


        }
        Spacer(modifier = Modifier.height(50.dp))


        Text(
            text = "Create Account",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, bottom = 20.dp)

        )
    }



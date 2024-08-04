package com.example.treads.screens

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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.astroadhyaycompose.R
import com.example.astroadhyaycompose.viewmodel.AuthViewModel
import com.example.treads.navigation.Routes
import com.spr.jetpack_loading.components.indicators.LineSpinFadeLoaderIndicator


@Composable
fun Login (navController: NavHostController){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 40.dp)
            .verticalScroll(rememberScrollState())
            .imePadding()
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "AstroAdhyaay" ,
            color = MaterialTheme.colorScheme.onBackground ,
            fontSize = 35.sp,

            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp)

        )
        Spacer(modifier = Modifier.height(150.dp))
        Text(text = "Login Now!" ,
            color = MaterialTheme.colorScheme.onBackground ,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp)

        )
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .padding(start = 40.dp)
                .align(Alignment.Start)
                .clickable {
                    navController.navigate(Routes.Registration.routes) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }

                }

        ) {
            Text(text = "Not registered/" ,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Light
            )
            Text(text = "  Create New " ,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold
            )
        }
        TextInput(navController)






    }

}

@Composable
fun TextInput(navController: NavHostController){
    var email by rememberSaveable {
        mutableStateOf("")
    }
    val color = MaterialTheme.colorScheme.primary
//
//    val authViewModel : AuthViewModel = viewModel()
//    val loading by authViewModel.loading.observeAsState(false)
//
//    val firebaseUser by authViewModel.firebaseUser.observeAsState()
//    val error by authViewModel.error.observeAsState()


//    LaunchedEffect(firebaseUser) {
//        if (firebaseUser != null){
//            navController.navigate(Routes.BottomNav.routes) {
//                popUpTo(navController.graph.startDestinationId)
//                launchSingleTop = true
//            }
//        }
//
//    }



OutlinedTextField(

    leadingIcon = {
        Icon(
            imageVector = Icons.Default.Email,
            contentDescription = null
        )
    },
    colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = color
        ,
        focusedLabelColor = color),

    value = email,
    shape = RoundedCornerShape(10.dp),
    onValueChange = {email = it},label = {
        Text(text = "Email" ,  fontWeight = FontWeight.SemiBold) },

    keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Email
    ),
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 40.dp, vertical = 40.dp)

)

    var password by remember {
        mutableStateOf("")
    }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val passwordIcon = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
    val passwordIconDescription = if (passwordVisible) "Hide password" else "Show password"

    OutlinedTextField(

        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Password,
                contentDescription = null
            )
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = passwordIcon, contentDescription = passwordIconDescription)
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = color
            ,
            focusedLabelColor = color
        ),

        value = password,
        shape = RoundedCornerShape(10.dp),
        onValueChange = {password = it},label = {
            Text(text = "Password" , textAlign = TextAlign.Center , fontWeight = FontWeight.SemiBold) },

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
    )

    Spacer(modifier = Modifier.height(30.dp))
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .padding(start = 40.dp)
            .clickable { }

    ) {
        Text(text = "Forgot Password? /" ,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
        )
        Text(text = "  Reset " ,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold
        )
    }

    Spacer(modifier = Modifier.height(30.dp))

    val context = LocalContext.current

    ElevatedButton(onClick = {
//        authViewModel.login(email , password , context)

        navController.navigate(Routes.BottomNav.routes) {
                popUpTo(navController.graph.startDestinationId)
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
                horizontal = 40.dp,
                vertical = 10.dp
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
//    error?.let {
//        Text(
//            text = it,
//            fontSize = 14.sp,
//            textAlign = TextAlign.Start,
//            color = Color.Red,
//            modifier = Modifier
//                .padding(40.dp)
//
//        )
//    }

}



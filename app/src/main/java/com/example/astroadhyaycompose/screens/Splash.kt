package com.example.astroadhyaycompose.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.astroadhyaycompose.R
import com.example.treads.navigation.Routes
import com.google.firebase.auth.FirebaseAuth
import com.spr.jetpack_loading.components.indicators.LineSpinFadeLoaderIndicator
import com.spr.jetpack_loading.components.indicators.PacmanIndicator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Composable
fun Splash (
    navController: NavHostController
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

            .background(color = MaterialTheme.colorScheme.background)
            .padding(40.dp)

    ) {
        Image(painter = painterResource(id = R.drawable.logo_bag), contentDescription = null ,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape))
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "AstroAdhyaay" ,
            color = MaterialTheme.colorScheme.onBackground)

        Spacer(modifier = Modifier.height(200.dp))

        LineSpinFadeLoaderIndicator(
            color = MaterialTheme.colorScheme.onBackground
        )

    }
    LaunchedEffect(true) {
        // Adding delay to allow splash screen to be visible for a while
        delay(3000)

        navController.navigate(Routes.Login.routes) {
            popUpTo(Routes.Splash.routes) { inclusive = true }

        }



    }


}


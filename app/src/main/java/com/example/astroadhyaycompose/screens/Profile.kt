package com.example.treads.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.astroadhyaycompose.screens.TopBarBackwithTitle
import com.example.astroadhyaycompose.viewmodel.AuthViewModel
import com.example.treads.navigation.Routes
import com.spr.jetpack_loading.components.indicators.LineSpinFadeLoaderIndicator


@Composable
fun Profile(navHostController: NavHostController)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 40.dp, start = 20.dp, end = 20.dp, bottom = 40.dp)
            .verticalScroll(rememberScrollState())
    ) {
        TopBarBackwithTitle(title = "Profile")
        ProfileSection()
        Spacer(modifier = Modifier.weight(1f))
        LogOutButton(navHostController)

    }





}

@Composable
fun ProfileSection(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 40.dp)
    ) {


        Icon(imageVector = Icons.Default.AccountCircle, contentDescription ="null" , tint = MaterialTheme.colorScheme.onBackground ,
            modifier = Modifier.size(80.dp))

        Spacer(modifier = Modifier.height(20.dp))
        UserDetail()


    }

    

}

@Composable
fun UserDetail(){
    Box(
        modifier = Modifier.size(200.dp).padding(40.dp).background(Color.DarkGray).clip(RoundedCornerShape(10.dp)),

    ){
        Column() {
            Text(text = "Name")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Email")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Phone")

        }

    }

}

@Composable
fun LogOutButton(navHostController: NavHostController){

    ElevatedButton(onClick = {


        navHostController.navigate(Routes.Login.routes) {
            popUpTo(navHostController.graph.startDestinationId)
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
            Text(text = "Logout" , fontSize = 20.sp , fontWeight = FontWeight.Bold  , color = MaterialTheme.colorScheme.background)

        }


    }

}
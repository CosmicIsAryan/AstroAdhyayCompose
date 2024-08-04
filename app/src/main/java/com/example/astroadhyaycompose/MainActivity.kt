package com.example.astroadhyaycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

import androidx.compose.ui.graphics.Color

import androidx.navigation.compose.rememberNavController
import com.example.astroadhyaycompose.ui.theme.AstroAdhyayComposeTheme
import com.example.treads.navigation.NavGraph
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AstroAdhyayComposeTheme {

                setBarColor(Color = MaterialTheme.colorScheme.background )
                val navController = rememberNavController()
                NavGraph(navController = navController)

            }
        }
    }
}


@Composable
private fun setBarColor( Color : Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color =  Color
        )
    }


}
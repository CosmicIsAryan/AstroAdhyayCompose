package com.example.treads.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.astroadhyaycompose.screens.BottomNav
import com.example.astroadhyaycompose.screens.PageTwo
import com.example.astroadhyaycompose.screens.Registration
import com.example.astroadhyaycompose.screens.Splash
import com.example.astroadhyaycompose.screens.kundli
import com.example.treads.screens.Home
import com.example.treads.screens.Login
import com.example.treads.screens.Notification
import com.example.treads.screens.Profile


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph (
    navController: NavHostController

) {
    NavHost (
        navController = navController,
        startDestination = Routes.Splash.routes,
        enterTransition = { slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700)) },
        exitTransition = { slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700)) }
    ) {
        composable(Routes.Splash.routes) {
            Splash(navController)
        }

        composable(Routes.Home.routes) {
            Home(navController)
        }

        composable(Routes.Notification.routes) {
            Notification()
        }

        composable(Routes.Profile.routes) {
            Profile(navController)
        }


        composable(Routes.BottomNav.routes) {
            BottomNav(navController)
        }

        composable(Routes.Login.routes) {
            Login(navController)
        }

        composable(Routes.Registration.routes) {
            Registration(navController)
        }

        composable(Routes.PageTwo.routes){
            PageTwo(navController)
        }
        composable(Routes.Kundli.routes){
            kundli()
        }
    }

}
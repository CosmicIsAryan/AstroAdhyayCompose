package com.example.astroadhyaycompose.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.treads.model.BottomNavItem
import com.example.treads.navigation.Routes
import com.example.treads.screens.Home
import com.example.treads.screens.Notification
import com.example.treads.screens.Profile
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild


@Composable
fun BottomNav (navController: NavHostController){
    val hazeState = remember { HazeState() }

   val  navController1 = rememberNavController ()

    Scaffold (

        bottomBar = {
            MyBottomBar( navController1 , hazeState)
        }
    ){
        innerPadding ->

        NavHost(navController = navController1, startDestination = Routes.Home.routes ,
        modifier = Modifier
            .padding(innerPadding)
            .haze(
                hazeState,
                backgroundColor = MaterialTheme.colorScheme.background,
                tint = Color.Black.copy(alpha = .02f),
                blurRadius = 30.dp,
                noiseFactor = 0.1f
            )){


            composable(Routes.Home.routes){
                Home(navController)
            }
            composable(Routes.Notification.routes){
                Notification()
            }
            composable(Routes.Profile.routes) {
                Profile(navController)
            }


        }
    }

}

@Composable
fun MyBottomBar(navController1: NavHostController , hazeState: HazeState) {

    val backStackEntry = navController1.currentBackStackEntryAsState()

    val list = listOf(
        BottomNavItem(
            title = "Home",
            icon = Icons.Rounded.Home,
            routes = Routes.Home.routes
        ),

        BottomNavItem(
            title = "Notification",
            icon = Icons.Rounded.Notifications,
            routes = Routes.Notification.routes
        ),
        BottomNavItem(
            title = "Profile",
            icon = Icons.Rounded.AccountCircle,
            routes = Routes.Profile.routes
        ),
    )

    BottomAppBar(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier
            .hazeChild(state = hazeState )
    ) {

        list.forEach{
            val selected = it.routes == backStackEntry.value?.destination?.route

            NavigationBarItem(selected = selected,




                onClick = {

                    navController1.navigate(it.routes){
                        popUpTo(navController1.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },

                icon = {
                   Icon(imageVector = it.icon, contentDescription = it.title  ,tint = MaterialTheme.colorScheme.onBackground)
                }

                ,
                label = {
                    Text(text = it.title ,
                        color = MaterialTheme.colorScheme.onBackground)
                }


            )
        }
    }

}

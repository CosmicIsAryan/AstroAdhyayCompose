package com.example.treads.navigation

sealed class Routes ( val routes: String) {
    object Splash : Routes("splash_screen")
    object Home : Routes("home_screen")
    object Notification : Routes("notification_screen")
    object Profile : Routes("profile_screen")
    object BottomNav : Routes("Bottom_nav")
    object Login : Routes("Login")
    object Registration : Routes("Registration")
    object PageTwo : Routes("page_two")
    object Kundli : Routes("kundli")


}
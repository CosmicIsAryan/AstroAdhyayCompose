package com.example.treads.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.treads.navigation.Routes

data class BottomNavItem(

    val title: String,
    val icon: ImageVector,
    val badgeCount: Int? = null,
    val routes: String
)

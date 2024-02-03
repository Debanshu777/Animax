package com.debanshu.animax.android.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import com.debanshu.animax.android.model.BottomNavItem

object constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Home",
            icon = Icons.Filled.Home,
            route = "home"
        ),
        BottomNavItem(
            label = "Favourite",
            icon = Icons.Filled.Favorite,
            route = "favourite"
        )
    )
}
package com.vku.learnzone.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val icon: ImageVector? = null
) {
    object SplashScreen : Screen("splash_screen")
    object SignInScreen : Screen("sign_in_screen")
    object SignUpScreen : Screen("sign_up_screen")
    object HomeScreen : Screen("home_screen", Icons.Default.Home)
    object CoursesScreen : Screen("courses_screen", Icons.Default.Menu)
    object WishlistScreen : Screen("wishlist_screen", Icons.Default.Favorite)
    object ProfileScreen : Screen("profile_screen", Icons.Default.Person)
    object DetailsScreen : Screen("details_screen")
    object PopularListScreen : Screen("popular_list_screen")
}

object Items {
    val items = listOf(
        Screen.HomeScreen,
        Screen.CoursesScreen,
        Screen.WishlistScreen,
        Screen.ProfileScreen
    )
}
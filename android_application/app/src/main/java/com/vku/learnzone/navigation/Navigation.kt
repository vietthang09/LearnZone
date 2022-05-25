package com.vku.learnzone.navigation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vku.learnzone.ui.theme.colorPrimary
import com.vku.learnzone.ui.theme.gray
import com.vku.learnzone.ui.theme.white
import com.vku.learnzone.view.*
import com.vku.learnzone.viewmodel.CourseViewModel


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val hideBottomNavigationList =
        listOf(
            Screen.SignInScreen.route,
            Screen.SignUpScreen.route,
            Screen.DetailsScreen.route,
            Screen.AwesomeCoursesScreen.route,
            Screen.CategoriesScreen.route,
            Screen.EnrolledDetailScreen.route
        )
    Scaffold(
        bottomBar = {
            if (!hideBottomNavigationList.contains(currentRoute)) {
                BottomNavigation(backgroundColor = white, elevation = 16.dp) {
                    Items.items.forEach {
                        BottomNavigationItem(
                            icon = {
                                it.icon?.let { it1 ->
                                    Icon(
                                        imageVector = it1,
                                        contentDescription = "",
                                        tint = if (currentRoute == it.route) colorPrimary else gray
                                    )
                                }
                            },
                            selected = currentRoute == it.route,
                            onClick = {
                                if (currentRoute != it.route) {
                                    navController.graph.startDestinationRoute?.let { item ->
                                        navController.popBackStack(
                                            item,
                                            false
                                        )
                                    }
                                }
                                if (currentRoute != it.route) {
                                    navController.navigate(it.route) {
                                        launchSingleTop = true
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    ) {
        ScreenController(navController = navController)
    }
}

@Composable
fun ScreenController(navController: NavHostController) {
    val vm = CourseViewModel()
    NavHost(navController = navController, startDestination = Screen.SignInScreen.route) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.SignInScreen.route) {
            SignInScreen(navController = navController)
        }
        composable(Screen.SignUpScreen.route) {
            SignUpScreen(navController = navController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController, viewModel = vm)
        }
        composable(Screen.CoursesScreen.route) {
            CoursesScreen(navController = navController)
        }
        composable(Screen.WishlistScreen.route) {
            WishlistScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen()
        }
        composable(Screen.DetailsScreen.route) {
            DetailsScreen(navController = navController)
        }
        composable(Screen.AwesomeCoursesScreen.route) {
            AwesomeCoursesScreen(navController = navController)
        }
        composable(Screen.CategoriesScreen.route) {
            CategoriesScreen(navController = navController)
        }
        composable(Screen.EnrolledDetailScreen.route) {
            EnrolledDetailScreen(navController = navController)
        }
    }
}


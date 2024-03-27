package com.khodadad.jetpackcomposetemplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.khodadad.jetpackcomposetemplate.ui.detail.DetailScreen
import com.khodadad.jetpackcomposetemplate.ui.home.MainScreen
import com.khodadad.jetpackcomposetemplate.ui.splash.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController, startDestination = Screen.Splash.route
    ) {

        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.Main.route) {
            MainScreen(navController = navController)
        }

        composable(Screen.Detail.route) {
            DetailScreen(navController = navController)
        }

    }
}
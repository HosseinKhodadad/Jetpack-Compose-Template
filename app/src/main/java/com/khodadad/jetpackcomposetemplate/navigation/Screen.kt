package com.khodadad.jetpackcomposetemplate.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Main : Screen("main_screen")
    object Detail : Screen("detail_screen")

}
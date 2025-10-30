package com.pdm.pratica1julia.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pdm.pratica1julia.ui.HomePage
import com.pdm.pratica1julia.ui.ListPage
import com.pdm.pratica1julia.ui.MapPage

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Route.Home) {
        composable<Route.Home> { HomePage() }
        composable<Route.List> { ListPage() }
        composable<Route.Map> { MapPage() }
    }
}

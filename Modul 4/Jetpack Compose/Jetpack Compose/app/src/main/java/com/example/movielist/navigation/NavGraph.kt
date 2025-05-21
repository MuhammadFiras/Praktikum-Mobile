package com.example.movielist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movielist.ui.screen.DetailScreen
import com.example.movielist.ui.screen.HomeScreen

object Routes {
    const val HOME = "home"
    const val DETAIL = "detail/{itemId}"
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(navController) // HomeScreen observes ViewModel directly
        }
        composable(Routes.DETAIL) { backStackEntry ->
            // Retrieve the itemId passed in the navigation
            val itemId = backStackEntry.arguments?.getString("itemId")?.toIntOrNull()
            if (itemId != null) {
                DetailScreen(itemId = itemId, navController = navController)
            }
        }
    }
}

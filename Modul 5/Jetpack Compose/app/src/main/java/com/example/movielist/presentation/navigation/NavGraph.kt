package com.example.movielist.presentation.navigation

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.movielist.ui.screen.DetailScreen
import com.example.movielist.ui.screen.HomeScreen
import com.example.movielist.viewmodel.MovieViewModel
import com.example.movielist.viewmodel.MovieViewModelFactory

object Routes {
    const val HOME = "home"
    const val DETAIL = "detail/{itemId}"
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    val context = LocalContext.current.applicationContext as Application
    val viewModel: MovieViewModel = viewModel(factory = MovieViewModelFactory(context))

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(navController, viewModel) // Pass shared ViewModel
        }

        composable(
            route = Routes.DETAIL,
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt("itemId") ?: -1
            DetailScreen(itemId = itemId, navController = navController, viewModel = viewModel)
        }
    }
}

package com.example.movielist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.movielist.presentation.navigation.AppNavGraph
import com.example.movielist.presentation.theme.MovieListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieListTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    AppNavGraph(navController = navController)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MainPreview() {
    MovieListTheme {
        val navController = rememberNavController()
        AppNavGraph(navController = navController)
    }
}

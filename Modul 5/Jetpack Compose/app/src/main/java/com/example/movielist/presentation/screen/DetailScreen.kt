package com.example.movielist.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movielist.viewmodel.MovieViewModel
import timber.log.Timber

@Composable
fun DetailScreen(
    itemId: Int,
    navController: NavController,
    viewModel: MovieViewModel
) {
    val item = viewModel.getMovieById(itemId)

    Timber.d("Loaded detail for item ID: $itemId - ${item?.title}")

    if (item != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${item.poster_path}",
                contentDescription = item.title,
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = item.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "⭐ ${item.vote_average}",
                fontSize = 18.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = item.overview ?: "No description available.",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.popBackStack() },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C27B0))
            ) {
                Text("Back")
            }
        }
    } else {
        Text("Item not found", color = Color.Red)
    }
}

package com.example.movielist.ui.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movielist.ui.viewmodel.MovieViewModel
import timber.log.Timber

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: MovieViewModel = viewModel()  // Use ViewModel for state management

    // Collecting the movie list from the ViewModel with initial empty list
    val movieListState = viewModel.movieList.collectAsState(initial = emptyList())

    // Accessing the list safely from the StateFlow
    val movieList = movieListState.value

    val context = LocalContext.current

    LazyColumn(
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(26.dp),
        modifier = Modifier.background(Color(0xFF000000))
    ) {
        itemsIndexed(movieList) { index, item ->  // Correct usage of itemsIndexed
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF141f1f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Movie Image
                    Image(
                        painter = painterResource(id = context.resources.getIdentifier(
                            item.imageResName, "drawable", context.packageName)),
                        contentDescription = item.name,
                        modifier = Modifier
                            .size(width = 90.dp, height = 130.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    // Movie Details
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = item.name,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Plot:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White
                        )

                        Text(
                            text = item.description,
                            fontSize = 13.sp,
                            color = Color(0xFFE0E0E0),
                            maxLines = 4
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(
                                onClick = {
                                    Timber.i("Opening IMDB link: ${item.link}")
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.link))
                                    context.startActivity(intent)
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB3E5FC)),
                                shape = RoundedCornerShape(50)
                            ) {
                                Text("IMDB", color = Color.Black)
                            }

                            Button(
                                onClick = {
                                    Timber.i("Navigating to DetailScreen with ID: ${item.id}")
                                    navController.navigate("detail/${item.id}")
                                    viewModel.selectMovie(item.id)  // Set the selected movie in the ViewModel
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9FA8DA)),
                                shape = RoundedCornerShape(50)
                            ) {
                                Text("Detail", color = Color.Black)
                            }
                        }
                    }
                }
            }
        }
    }
}

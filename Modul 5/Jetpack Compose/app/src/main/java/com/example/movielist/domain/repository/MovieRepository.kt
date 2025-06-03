package com.example.movielist.domain.repository

import android.content.Context
import com.example.movielist.data.api.RetrofitInstance
import com.example.movielist.data.db.MovieDao
import com.example.movielist.data.db.MovieDatabase
import com.example.movielist.data.db.MovieEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class MovieRepository(private val dao: MovieDao, private val context: Context) {

    suspend fun getMovies(apiKey: String): List<MovieEntity> {
        // Step 1: Load from local cache first
        val cachedMovies = dao.getAllMovies()
        Timber.i("Loaded ${cachedMovies.size} movies from cache.")

        return try {
            // Step 2: Fetch from API
            val response = RetrofitInstance.api.getPopularMovies(apiKey)
            val movies = response.results.map {
                MovieEntity(
                    id = it.id,
                    title = it.title,
                    overview = it.overview ?: "",
                    poster_path = it.posterPath ?: "",
                    vote_average = it.voteAverage
                )
            }

            // Step 3: Cache to DB
            dao.clearAll()
            dao.insertAll(movies)

            Timber.i("Fetched and cached ${movies.size} movies from API.")
            movies
        } catch (e: Exception) {
            Timber.e(e, "Error fetching movies. Using cache.")
            cachedMovies
        }
    }
}

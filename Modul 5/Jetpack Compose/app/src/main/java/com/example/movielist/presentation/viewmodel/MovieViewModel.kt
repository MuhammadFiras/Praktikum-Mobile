package com.example.movielist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.movielist.data.db.MovieDatabase
import com.example.movielist.data.db.MovieEntity
import com.example.movielist.domain.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val _movieList = MutableStateFlow<List<MovieEntity>>(emptyList())
    val movieList: StateFlow<List<MovieEntity>> get() = _movieList

    private val repository = MovieRepository(
        dao = MovieDatabase.getDatabase(application).movieDao(),
        context = application
    )

    private val apiKey = "5599d93394ce2696cbe43b45ce6d173d"

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            val data = repository.getMovies(apiKey)
            _movieList.value = data
        }
    }

    fun getMovieById(id: Int): MovieEntity? {
        return _movieList.value.find { it.id == id }
    }
}

package com.example.movielist.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.movielist.model.ListItem
import com.example.movielist.model.listItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MovieViewModel : ViewModel() {

    // Initializing movieList with a default value
    private val _movieList = MutableStateFlow<List<ListItem>>(emptyList())  // Initially empty list
    val movieList: StateFlow<List<ListItem>> get() = _movieList

    // Initialize the list with data (just as an example)
    init {
        _movieList.value = listItems  // populate movie list with your data
        timber.log.Timber.d("Movie list initialized with ${listItems.size} items.")
    }

    private val _selectedMovieId = MutableStateFlow<Int?>(null)
    val selectedMovieId: StateFlow<Int?> get() = _selectedMovieId

    fun selectMovie(id: Int) {
        _selectedMovieId.value = id
    }

    fun getMovieById(id: Int): ListItem? {
        return _movieList.value.find { it.id == id }
    }
}

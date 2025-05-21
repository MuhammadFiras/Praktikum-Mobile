package com.example.movielistxml.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movielistxml.model.ListItem
import com.example.movielistxml.model.listItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber

class MovieViewModel (private val sourceName: String) : ViewModel() {

    // Movie list
    private val _movieList = MutableStateFlow(listItems)
    val movieList: StateFlow<List<ListItem>> get() = _movieList

    init {
        Timber.i("Movie list initialized with ${listItems.size} items from source: $sourceName")
    }

    // Selected item (by ID)
    private val _selectedItemId = MutableStateFlow<Int?>(null)
    val selectedItemId: StateFlow<Int?> get() = _selectedItemId

    fun selectItem(id: Int) {
        _selectedItemId.value = id
    }

    fun getMovieById(id: Int): ListItem? {
        return _movieList.value.find { it.id == id }
    }
}

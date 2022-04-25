package com.example.filmslist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmslist.data.FilmsRepository
import com.example.filmslist.dto.Film
import com.example.filmslist.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val filmsRepository: FilmsRepository
) : ViewModel() {

    private val _filmList: MutableLiveData<ArrayList<Film>> = MutableLiveData()
    val filmList: LiveData<ArrayList<Film>> = _filmList

    init {
        viewModelScope.launch {
            _filmList.value = filmsRepository.getFilms()
        }
    }
}
package com.example.movie_compose.ui_layer

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie_compose.common.Resource
import com.example.movie_compose.data.MovieDetailStateHolder
import com.example.movie_compose.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Mohammad Kashif Ansari on 07,April,2024
 */

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val movieRepository: MovieRepository,savedStateHandle: SavedStateHandle):ViewModel() {

    val movieDetails= mutableStateOf(MovieDetailStateHolder())

    init {
        movieDetails.value=MovieDetailStateHolder(isLoading = true)
        viewModelScope.launch {
            savedStateHandle.getStateFlow("id","0").collectLatest {
                getMovieDetails(it)
            }
        }

    }
    fun getMovieDetails(id:String)=viewModelScope.launch {
        val result=movieRepository.getMovieDetails(id)
        when (result){
            is Resource.Success->{
                movieDetails.value= MovieDetailStateHolder(data = result.data)
            }
            is Resource.Error->{
                movieDetails.value= MovieDetailStateHolder(error = result.message.toString())
            }else-> {

            }
        }
    }
}
package com.example.movie_compose.ui_layer

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie_compose.common.Resource
import com.example.movie_compose.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Mohammad Kashif Ansari on 06,April,2024
 */

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository):ViewModel() {

    val movieList= mutableStateOf(MovieStateHolder())
    init {
        movieList.value= MovieStateHolder(isLoading = true)
        getMovieList()
    }
    fun getMovieList()=viewModelScope.launch(Dispatchers.IO) {
       val result= movieRepository.getMovieList()
        when(result){
            is Resource.Loading->{

            }
            is Resource.Success->{
                movieList.value= MovieStateHolder(data = result.data)
            }
            is Resource.Error->{
                movieList.value= MovieStateHolder(error = result.message.toString())
            }
            else->{

            }
        }
    }
}
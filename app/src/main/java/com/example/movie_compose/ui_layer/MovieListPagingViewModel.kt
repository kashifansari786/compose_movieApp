package com.example.movie_compose.ui_layer

import androidx.lifecycle.ViewModel
import com.example.movie_compose.repository.MovieRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Mohammad Kashif Ansari on 13,April,2024
 */

@HiltViewModel
class MovieListPagingViewModel @Inject constructor(private val repo: MovieRepo):ViewModel() {

        val pagingData=repo.getMovieStream()

}
package com.example.movie_compose.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.movie_compose.model.Movie
import com.example.movie_compose.model.MovieListResponse
import com.example.movie_compose.network.ApiService
import com.example.movie_compose.paging.BasePagingSource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Mohammad Kashif Ansari on 13,April,2024
 */
class MovieRepo(private val apiService: ApiService) {

    fun getMovieStream():Flow<PagingData<Movie>>{
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 5,
                enablePlaceholders = false,
                initialLoadSize = 10
            ), pagingSourceFactory = {
                BasePagingSource(apiService)
            }
        ).flow
    }
}
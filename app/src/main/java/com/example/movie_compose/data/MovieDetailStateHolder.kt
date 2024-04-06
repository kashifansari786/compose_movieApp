package com.example.movie_compose.data

import com.example.movie_compose.model.details.MovieDetailsModel

/**
 * Created by Mohammad Kashif Ansari on 07,April,2024
 */
data class MovieDetailStateHolder(
    val isLoading:Boolean=false,
    val data:MovieDetailsModel?=null,
    val error:String=""
)
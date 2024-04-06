package com.example.movie_compose.ui_layer

import com.example.movie_compose.model.Movie

/**
 * Created by Mohammad Kashif Ansari on 06,April,2024
 */
data class MovieStateHolder(
    val isLoading:Boolean=false,
    val data:List<Movie>?=null,
    val error:String=""

)
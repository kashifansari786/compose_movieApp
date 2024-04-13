package com.example.movie_compose.data

import com.example.movie_compose.network.ApiService

/**
 * Created by Mohammad Kashif Ansari on 06,April,2024
 */
class MovieDataSource(private val apiService:ApiService) {

    suspend fun getMovieList()=apiService.getMovieList("8c0067d631aa70fb15eaf0b9f56f1e6a")  //use your api key which you will get on imdb movie
    suspend fun getMovieDetails(id:String)=apiService.getMovieDetails(id,"8c0067d631aa70fb15eaf0b9f56f1e6a")
}
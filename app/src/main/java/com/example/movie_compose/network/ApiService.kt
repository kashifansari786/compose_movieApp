package com.example.movie_compose.network

import com.example.movie_compose.model.MovieListResponse
import com.example.movie_compose.model.details.MovieDetailsModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Mohammad Kashif Ansari on 06,April,2024
 */
interface ApiService {

    //https://api.themoviedb.org/3/movie/popular?api_key=8c0067d631aa70fb15eaf0b9f56f1e6a
    @GET("3/movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String
    ):MovieListResponse

    @GET("3/movie/{id}")
    suspend fun getMovieDetails(
        @Path("id")id:String,
        @Query("api_key") apiKey: String
    ):MovieDetailsModel

}
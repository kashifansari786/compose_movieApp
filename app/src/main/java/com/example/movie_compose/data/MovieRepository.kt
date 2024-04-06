package com.example.movie_compose.data

import com.example.movie_compose.common.Resource
import com.example.movie_compose.model.Movie
import com.example.movie_compose.model.details.MovieDetailsModel

/**
 * Created by Mohammad Kashif Ansari on 06,April,2024
 */
class MovieRepository(private val movieDataSource: MovieDataSource) {

    suspend fun getMovieList(): Resource<List<Movie>> {
        return try {
            Resource.Success(data = movieDataSource.getMovieList().results)
        }catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }

    suspend fun getMovieDetails(id:String):Resource<MovieDetailsModel>{
        return try {
            Resource.Success(data = movieDataSource.getMovieDetails(id))
        }catch (e:Exception)
        {
            Resource.Error(e.message.toString())
        }
    }
}
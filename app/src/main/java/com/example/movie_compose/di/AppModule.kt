package com.example.movie_compose.di

import com.example.movie_compose.data.MovieDataSource
import com.example.movie_compose.data.MovieRepository
import com.example.movie_compose.network.ApiService
import com.example.movie_compose.repository.MovieRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * Created by Mohammad Kashif Ansari on 06,April,2024
 */

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun providesRetrofit():ApiService{
        return Retrofit
            .Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

//    @Provides
//    fun provideApiService(retrofit:Retrofit):ApiService{
//        return retrofit.create(ApiService::class.java)
//    }

    @Provides
    fun provideMoviePaginationRepo(apiService: ApiService): MovieRepo {
        return MovieRepo(apiService)
    }
    @Provides
    fun provideDataSource(apiService: ApiService):MovieDataSource{
        return MovieDataSource(apiService)
    }

    @Provides
    fun provideMoviRepo(dataSource: MovieDataSource):MovieRepository{
        return MovieRepository(dataSource)
    }
}
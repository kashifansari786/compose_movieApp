package com.example.movie_compose.di

import com.example.movie_compose.data.MovieDataSource
import com.example.movie_compose.data.MovieRepository
import com.example.movie_compose.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Mohammad Kashif Ansari on 06,April,2024
 */

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApiService(retrofit:Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
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
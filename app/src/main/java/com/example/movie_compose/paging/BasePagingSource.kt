package com.example.movie_compose.paging

import android.net.http.HttpException
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movie_compose.model.Movie
import com.example.movie_compose.model.MovieListResponse
import com.example.movie_compose.network.ApiService
import com.example.movie_compose.ui_layer.MovieDetailsViewModel
import kotlinx.coroutines.delay
import java.io.IOException

/**
 * Created by Mohammad Kashif Ansari on 13,April,2024
 */
class BasePagingSource(private val apiService: ApiService) :PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? { //it will tell you previous page like we have to fetch page 2 so it will tell you that previous page is 1
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)?:  //if state is not null then pass 1 to prevKey
            state.closestPageToPosition(it)?.nextKey?.minus(1)   //if state is null the we pass -1 to nextKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val position=params.key?:1 //first time it will return null so we put 1
        return try {
            delay(3000)
                val remoteData=apiService.getMovieAllList("",params.loadSize)
            val nextKey= if(remoteData.results.size<params.loadSize){  //we are in last page
                null
            }else{
                position+1
            }
            LoadResult.Page(
                remoteData.results,
                prevKey = if(position==1)null else position-1,
                nextKey = nextKey)
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }


}
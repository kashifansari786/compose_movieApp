package com.example.movie_compose.ui_layer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.movie_compose.navigation.MovieNavigationItem

/**
 * Created by Mohammad Kashif Ansari on 06,April,2024
 */

@Composable
fun MovieListScreen(navController: NavController,viewModel: MovieViewModel= hiltViewModel()){

    val result=viewModel.movieList.value
    if(result.isLoading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }
    if(result.error.isNotBlank()){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text = result.error)
        }
    }
    result.data?.let {
        LazyColumn {
           items(result.data){
               MovieItem(it = it){
                   navController.navigate(MovieNavigationItem.MovieDetails.route+"/$it")
               }
           }
        }
    }
}
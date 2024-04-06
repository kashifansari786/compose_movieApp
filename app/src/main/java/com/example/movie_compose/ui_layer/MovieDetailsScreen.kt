package com.example.movie_compose.ui_layer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

/**
 * Created by Mohammad Kashif Ansari on 06,April,2024
 */

@Composable
fun MovieDetailsScreen(viewModel: MovieDetailsViewModel= hiltViewModel()) {

    val result=viewModel.movieDetails.value

    if(result.isLoading)
    {
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
        Column(modifier = Modifier.padding(12.dp)) {
            AsyncImage(model = "https://image.tmdb.org/t/p/w500/${it.poster_path}",
                contentDescription =null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.FillBounds)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = it.original_title, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = it.tagline, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = it.overview, style = MaterialTheme.typography.bodyMedium)
        }
    }

}
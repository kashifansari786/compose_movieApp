package com.example.movie_compose.ui_layer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movie_compose.model.Movie

/**
 * Created by Mohammad Kashif Ansari on 06,April,2024
 */

@Composable
fun MovieItem(it:Movie,onClick:(String)->Unit) {
    AsyncImage(model = "https://image.tmdb.org/t/p/w500/${it.poster_path}",
        contentDescription = null,
        modifier = Modifier.fillMaxWidth()
                            .height(300.dp)
                            .padding(vertical = 2.dp)
            .clickable { onClick.invoke(it.id.toString()) },
        contentScale = ContentScale.Crop)
}

//@Composable
//fun MoviePaginationItem(it:Movie,onClick:(String)->Unit) {
//    AsyncImage(model = "https://image.tmdb.org/t/p/w500/${it.poster_path}",
//        contentDescription = null,
//        modifier = Modifier.fillMaxWidth()
//            .height(300.dp)
//            .padding(vertical = 2.dp)
//            .clickable { onClick.invoke(it.id.toString()) },
//        contentScale = ContentScale.Crop)
//}
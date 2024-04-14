package com.example.movie_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.movie_compose.ui_layer.MovieItem
import com.example.movie_compose.ui_layer.MovieListPagingViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay

/**
 * Created by Mohammad Kashif Ansari on 14,April,2024
 */

@Composable
fun moviePagination(viewModel: MovieListPagingViewModel){
    val pagination=viewModel.pagingData.collectAsLazyPagingItems()
    val swipeToRefreshState= rememberSwipeRefreshState(isRefreshing = false)
    //implement swipe to refresh
    SwipeRefresh(state = swipeToRefreshState, onRefresh = {

        pagination.refresh()
        swipeToRefreshState.isRefreshing=true
    }) {
        pagination?.let {
            LazyColumn {
                //loadState.append = if we want to get next page then we will call append
                //loadState.prepend = if we want to get previous page then we will call prepend
                //loadState.refresh = if we want to refresh page then we will call refresh
                if(pagination.loadState.refresh is LoadState.Loading){  // check LoadState is in loading then we call below
                    item {
                        Box(modifier = Modifier.fillParentMaxSize()){
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                        }
                    }
                }
                //is LoadState is not loading means data is displayed on the screen
                if(pagination.loadState.refresh is LoadState.NotLoading){
                    swipeToRefreshState.isRefreshing=false
                    items(pagination.itemCount){
                        val item=pagination[it]
                        item?.let {
                            MovieItem(it = it) {

                            }
                        }
                    }
                }
                //if we get any error then we will show error message
                if(pagination.loadState.refresh is LoadState.Error){
                    item{
                        Box(modifier = Modifier.fillParentMaxSize()){
                            Text(text = "Error Occured", modifier = Modifier.clickable {
                                pagination.refresh()  //data is load again
                            })
                        }
                    }
                }

                if(pagination.loadState.append is LoadState.Loading){
                    item{
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)){
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                        }
                    }
                }
                //if we get any error then we will show error message and retry
                if(pagination.loadState.append is LoadState.Error){
                    item {
                        ErrorFooter(){
                            pagination.retry()
                        }
                    }

                }

                if(pagination.loadState.prepend is LoadState.Loading){
                    item{
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)){
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                        }
                    }
                }
                //if we get any error then we will show error message and retry
                if(pagination.loadState.prepend is LoadState.Error){
                    item {
                        ErrorHeader(){
                            pagination.retry()
                        }
                    }

                }



            }
        }
    }


}


@Composable
fun ErrorHeader(retry:()->Unit={}) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)){
        Text(
            text = "Tap to Retry",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .clickable {
                    retry.invoke()
                }
                .align(Alignment.CenterEnd))
    }
}


@Composable
fun ErrorFooter(retry:()->Unit={}) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)){
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(imageVector = Icons.Default.Warning, contentDescription = null)
            Text(text = "Error Occured", style = MaterialTheme.typography.bodyMedium)
            Box(modifier = Modifier.fillMaxWidth()){
                Text(
                    text = "Retry",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .clickable {
                            retry.invoke()
                        }
                        .align(Alignment.CenterEnd))
            }
        }
    }
}

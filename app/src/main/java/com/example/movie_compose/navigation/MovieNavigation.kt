package com.example.movie_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movie_compose.ui_layer.MovieDetailsScreen
import com.example.movie_compose.ui_layer.MovieListScreen

/**
 * Created by Mohammad Kashif Ansari on 06,April,2024
 */

@Composable
fun MovieNavigation(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = MovieNavigationItem.MovieList.route){
//        navigation(startDestination = "", route = ""){   //it is used when you have multiple nav graph so youhave to build each nav graph seperatly
//            composable(){
//
//            }
//        }
        composable(MovieNavigationItem.MovieList.route){
            MovieListScreen(navHostController)
        }
        composable(MovieNavigationItem.MovieDetails.route+"/{id}"){
            val id=it.arguments?.getString("id")
            MovieDetailsScreen()

        }
    }
}

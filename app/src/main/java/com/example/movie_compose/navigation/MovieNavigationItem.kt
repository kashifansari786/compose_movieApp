package com.example.movie_compose.navigation

/**
 * Created by Mohammad Kashif Ansari on 06,April,2024
 */
sealed class MovieNavigationItem(val route:String) {

    object MovieList:MovieNavigationItem("movie_list")
    object MovieDetails:MovieNavigationItem("movie_details")
}
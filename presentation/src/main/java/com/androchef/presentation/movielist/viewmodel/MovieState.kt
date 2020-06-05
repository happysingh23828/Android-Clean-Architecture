package com.androchef.presentation.movielist.viewmodel

import com.androchef.presentation.movielist.models.MovieView

sealed class MovieState {
    object Init : MovieState()
    object Loading : MovieState()
    data class Error(var message: String) : MovieState()
    data class MovieListSuccess(var listOfMovieViews: List<MovieView>) : MovieState()
    object BookmarkChangeSuccess : MovieState()
}

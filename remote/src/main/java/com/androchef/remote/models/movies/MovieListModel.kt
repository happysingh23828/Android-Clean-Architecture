package com.androchef.remote.models.movies

import com.google.gson.annotations.SerializedName

class MovieListModel(

    @SerializedName("page")
    var page: Int = 0,

    @SerializedName("results")
    var listOfMoviesResponse: MutableList<MovieModel> = mutableListOf(),

    @SerializedName("total_pages")
    var totalPages: Int = 0,

    @SerializedName("total_results")
    var totalResults: Int = 0
)

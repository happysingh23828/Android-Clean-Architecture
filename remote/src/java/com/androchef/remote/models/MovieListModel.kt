package com.androchef.remote.models

import com.google.gson.annotations.SerializedName

class MovieListModel(

    @SerializedName("page")
    var page: Int = 0,

    @SerializedName("results")
    var listOfMoviesResponse: List<MovieModel> = listOf(),

    @SerializedName("total_pages")
    var totalPages: Int = 0,

    @SerializedName("total_results")
    var totalResults: Int = 0
)
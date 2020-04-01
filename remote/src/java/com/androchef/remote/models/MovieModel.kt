package com.androchef.remote.models

import com.google.gson.annotations.SerializedName

class MovieModel (

    @SerializedName("adult")
    var adult: Boolean = false,

    @SerializedName("backdrop_path")
    var backdropPath: String? = "",

    @SerializedName("name")
    var name: String = "",

    @SerializedName("genre_ids")
    var genreIds: List<Int> = listOf(),

    @SerializedName("id")
    var id: Long? = 0,

    @SerializedName("original_language")
    var originalLanguage: String = "",

    @SerializedName("original_title")
    var originalTitle: String? = "",

    @SerializedName("overview")
    var overview: String = "",

    @SerializedName("popularity")
    var popularity: Double = 0.0,

    @SerializedName("poster_path")
    var posterPath: String? = "",

    @SerializedName("release_date")
    var releaseDate: String? = "",

    @SerializedName("first_air_date")
    var first_air_date: String? = "",

    @SerializedName("title")
    var title: String? = "",

    @SerializedName("known_for_department")
    var known_for_department: String = "",

    @SerializedName("profile_path")
    var profile_path: String = "",

    @SerializedName("video")
    var video: Boolean = false,

    @SerializedName("vote_average")
    var voteAverage: Double? = 0.0,

    @SerializedName("vote_count")
    var voteCount: Int = 0
)
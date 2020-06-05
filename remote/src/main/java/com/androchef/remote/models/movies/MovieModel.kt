package com.androchef.remote.models.movies

import com.google.gson.annotations.SerializedName

class MovieModel(

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
    var firstAirDate: String? = "",

    @SerializedName("title")
    var title: String? = "",

    @SerializedName("known_for_department")
    var knownForDepartment: String = "",

    @SerializedName("profile_path")
    var profilePath: String = "",

    @SerializedName("video")
    var video: Boolean = false,

    @SerializedName("vote_average")
    var voteAverage: Double? = 0.0,

    @SerializedName("vote_count")
    var voteCount: Int = 0
)

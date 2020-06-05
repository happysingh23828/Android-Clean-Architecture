package com.androchef.remote.models.credits

import com.google.gson.annotations.SerializedName

data class MovieCreditsModel(
    @SerializedName("cast")
    var cast: List<CastModel> = listOf(),
    @SerializedName("crew")
    var crew: List<CrewModel> = listOf(),
    @SerializedName("id")
    var id: Int = 0
)

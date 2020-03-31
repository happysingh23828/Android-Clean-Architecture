package com.androchef.domain.models.movies

data class Cast(
    var cast_id: Int = 0,
    var character: String = "",
    var credit_id: String = "",
    var gender: Int = 0,
    var id: Int = 0,
    var name: String = "",
    var order: Int = 0,
    var profile_path: String = ""
)
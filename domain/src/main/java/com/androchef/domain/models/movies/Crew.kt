package com.androchef.domain.models.movies

data class Crew(
    var credit_id: String = "",
    var department: String = "",
    var gender: Int = 0,
    var id: Int = 0,
    var job: String = "",
    var name: String = "",
    var profile_path: String = ""
)
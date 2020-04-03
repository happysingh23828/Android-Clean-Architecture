package com.androchef.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.androchef.cache.db.CacheConstants

@Entity(tableName = CacheConstants.MOVIE_TABLE_NAME)
data class CachedMovie (
    @PrimaryKey
    var  id : Long,

    @ColumnInfo(name = "title")
    var title : String? ="",

    @ColumnInfo(name = "name")
    var name : String? ="",

    @ColumnInfo(name = "voteAverage")
    var voteAverage : Double? = 0.0,

    @ColumnInfo(name = "profilePath")
    var profilePath :String? = "",

    @ColumnInfo(name = "posterPath")
    var posterPath :String? = "",

    @ColumnInfo(name = "isBookMarked")
    var isBookMarked : Boolean
)
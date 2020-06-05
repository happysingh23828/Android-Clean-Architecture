package com.androchef.remote.factory.movies

import com.androchef.data.models.MovieEntity
import com.androchef.remote.factory.DataFactory
import com.androchef.remote.models.movies.MovieListModel
import com.androchef.remote.models.movies.MovieModel

object RemoteMovieFactory {

    private const val TOTAL_PAGE_NO = 1000
    private const val TOTAL_RESULTS = 100000

    fun generateMovieListModel(size: Int, pageNo: Int): MovieListModel {
        val movieListModel = MovieListModel()
        movieListModel.listOfMoviesResponse = generateListOfMovieModel(size)
        movieListModel.page = pageNo
        movieListModel.totalPages = TOTAL_PAGE_NO
        movieListModel.totalResults = TOTAL_RESULTS
        return movieListModel
    }

    fun generateListOfMovieModel(size: Int): MutableList<MovieModel> {
        val listOfMovieModels = mutableListOf<MovieModel>()
        repeat(size) {
            listOfMovieModels.add(generateMovieModel())
        }
        return listOfMovieModels
    }

    fun generateMovieModel(): MovieModel {
        return MovieModel(
            adult = DataFactory.getRandomBoolean(),
            name = DataFactory.getRandomString(),
            title = DataFactory.getRandomString(),
            voteAverage = DataFactory.getRandomDouble(),
            posterPath = DataFactory.getRandomString(),
            id = DataFactory.getRandomLong(),
            video = DataFactory.getRandomBoolean(),
            overview = DataFactory.getRandomString(),
            knownForDepartment = DataFactory.getRandomString(),
            firstAirDate = DataFactory.getRandomString(),
            popularity = DataFactory.getRandomDouble(),
            profilePath = DataFactory.getRandomString(),
            backdropPath = DataFactory.getRandomString(),
            genreIds = mutableListOf(),
            originalLanguage = DataFactory.getRandomString(),
            originalTitle = DataFactory.getRandomString(),
            releaseDate = DataFactory.getRandomString(),
            voteCount = DataFactory.getRandomInt()
        )
    }

    fun generateMovieEntity(): MovieEntity {
        return MovieEntity(
            id = DataFactory.getRandomLong(),
            posterPath = DataFactory.getRandomString(),
            profilePath = DataFactory.getRandomString(),
            voteAverage = DataFactory.getRandomDouble(),
            isBookMarked = DataFactory.getRandomBoolean(),
            movieTitle = DataFactory.getRandomString(),
            movieName = DataFactory.getRandomString()
        )
    }
}

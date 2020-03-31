package com.androchef.domain.interactor.movielist

import com.androchef.domain.executor.PostExecutionThread
import com.androchef.domain.executor.ThreadExecutor
import com.androchef.domain.interactor.BaseUseCase
import com.androchef.domain.models.movies.MoviesList
import com.androchef.domain.repositories.MovieRepository
import io.reactivex.Single

class GetMovieListUseCase constructor(
    private val movieRepository: MovieRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : BaseUseCase<BaseUseCase.EmptyParam, GetMovieListUseCase.ResponseValues>(
    threadExecutor, postExecutionThread
) {

    override fun buildUseCaseObservable(requestValues: EmptyParam?): Single<ResponseValues> {
        return movieRepository.getPopularMovies()
    }

    /**
     * API Response
     */
    data class ResponseValues(val movieList: MoviesList) : ResponseValue
}
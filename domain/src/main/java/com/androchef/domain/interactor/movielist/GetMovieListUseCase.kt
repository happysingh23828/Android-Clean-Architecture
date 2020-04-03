package com.androchef.domain.interactor.movielist

import com.androchef.domain.executor.PostExecutionThread
import com.androchef.domain.executor.ThreadExecutor
import com.androchef.domain.interactor.BaseUseCase
import com.androchef.domain.models.movies.Movie
import com.androchef.domain.models.movies.MoviesList
import com.androchef.domain.repositories.MovieRepository
import io.reactivex.Single

class GetMovieListUseCase constructor(
    private val movieRepository: MovieRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : BaseUseCase<Void,List<Movie>>(
    threadExecutor, postExecutionThread
) {
    override fun buildUseCaseObservable(requestValues: Void?): Single<List<Movie>> {
        return movieRepository.getPopularMovies()
    }
}
package com.androchef.domain.interactor.moviecredits

import com.androchef.domain.SingleUseCase
import com.androchef.domain.executor.PostExecutionThread
import com.androchef.domain.executor.ThreadExecutor
import com.androchef.domain.models.movies.MovieCredits
import com.androchef.domain.repositories.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class GetMovieCreditsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<GetMovieCreditsUseCase.Params, MovieCredits>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(requestValues: Params?): Single<MovieCredits> {
        return movieRepository.getMovieCredits(requestValues!!.movieId.toLong())
    }

    /**
     * [movieId] to fetch MovieCredits
     */
    data class Params(
        val movieId: Int
    )
}

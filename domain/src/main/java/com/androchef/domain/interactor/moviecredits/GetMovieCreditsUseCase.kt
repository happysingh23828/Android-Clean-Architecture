package com.androchef.domain.interactor.moviecredits

import com.androchef.domain.executor.PostExecutionThread
import com.androchef.domain.executor.ThreadExecutor
import com.androchef.domain.interactor.BaseUseCase
import com.androchef.domain.models.movies.MovieCredits
import com.androchef.domain.repositories.MovieRepository
import io.reactivex.Single

class GetMovieCreditsUseCase(
    private val movieRepository: MovieRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : BaseUseCase<GetMovieCreditsUseCase.Params,GetMovieCreditsUseCase.ResponseValues>(threadExecutor,postExecutionThread) {

    override fun buildUseCaseObservable(requestValues: Params?): Single<ResponseValues> {
        return movieRepository.getMovieCredits(requestValues!!.movieId)
    }

    /**
     * [movieId] to fetch MovieCredits
     */
    data class Params(
        val movieId: Int
    ) : BaseUseCase.Params

    /**
     * Response value [MovieCredits]
     */
    data class ResponseValues(val movieCredits: MovieCredits) : BaseUseCase.ResponseValue
}
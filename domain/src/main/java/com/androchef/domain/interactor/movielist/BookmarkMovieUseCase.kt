package com.androchef.domain.interactor.movielist

import com.androchef.domain.CompletableUseCase
import com.androchef.domain.executor.PostExecutionThread
import com.androchef.domain.executor.ThreadExecutor
import com.androchef.domain.repositories.MovieRepository
import io.reactivex.Completable
import javax.inject.Inject

class BookmarkMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : CompletableUseCase<Long>(
    threadExecutor, postExecutionThread
) {
    public override fun buildUseCaseObservable(requestValues: Long?): Completable {
        return movieRepository.bookmarkMovie(requestValues!!)
    }
}

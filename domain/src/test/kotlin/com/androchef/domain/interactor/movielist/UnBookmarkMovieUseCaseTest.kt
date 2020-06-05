package com.androchef.domain.interactor.movielist

import com.androchef.domain.executor.PostExecutionThread
import com.androchef.domain.executor.ThreadExecutor
import com.androchef.domain.repositories.MovieRepository
import io.reactivex.Completable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UnBookmarkMovieUseCaseTest {

    @Mock
    lateinit var movieRepository: MovieRepository

    @Mock
    lateinit var threadExecutor: ThreadExecutor

    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    lateinit var unBookmarkMovieUseCase: UnBookmarkMovieUseCase

    @Before
    fun setUp() {
        unBookmarkMovieUseCase =
            UnBookmarkMovieUseCase(movieRepository, threadExecutor, postExecutionThread)
    }

    @Test
    fun buildUseCaseObservable_callRepository() {
        // Arrange
        // No Arrangement for this test case

        // Act
        unBookmarkMovieUseCase.buildUseCaseObservable(2)

        // Assert
        Mockito.verify(movieRepository).unBookmarkMovie(2)
    }

    @Test
    fun buildUseCaseObservable_completes() {
        // Arrange
        val movieId = 3L
        stubMovieRepositoryUnBookmarkMovie(movieId, Completable.complete())

        // Act
        val test = movieRepository.unBookmarkMovie(movieId).test()

        // Assert
        test.assertComplete()
    }

    private fun stubMovieRepositoryUnBookmarkMovie(movieId: Long, completable: Completable) {
        Mockito.`when`(movieRepository.unBookmarkMovie(movieId))
            .thenReturn(completable)
    }
}

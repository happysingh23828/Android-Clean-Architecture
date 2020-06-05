package com.androchef.domain.interactor.movielist

import com.androchef.domain.executor.PostExecutionThread
import com.androchef.domain.executor.ThreadExecutor
import com.androchef.domain.repositories.MovieRepository
import io.reactivex.Completable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkMovieUseCaseTest {

    @Mock
    lateinit var movieRepository: MovieRepository

    @Mock
    lateinit var threadExecutor: ThreadExecutor

    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    lateinit var bookmarkMovieUseCase: BookmarkMovieUseCase

    @Before
    fun setUp() {
        bookmarkMovieUseCase =
            BookmarkMovieUseCase(movieRepository, threadExecutor, postExecutionThread)
    }

    @Test
    fun buildUseCaseObservable_callRepository() {
        // Arrange
        // No Arrangement for this test case

        // Act
        bookmarkMovieUseCase.buildUseCaseObservable(2)

        // Assert
        verify(movieRepository).bookmarkMovie(2)
    }

    @Test
    fun buildUseCaseObservable_completes() {
        // Arrange
        val movieId = 3L
        stubMovieRepositoryBookmarkMovie(movieId, Completable.complete())

        // Act
        val test = movieRepository.bookmarkMovie(movieId).test()

        // Assert
        test.assertComplete()
    }

    private fun stubMovieRepositoryBookmarkMovie(movieId: Long, completable: Completable) {
        `when`(movieRepository.bookmarkMovie(movieId))
            .thenReturn(completable)
    }
}

package com.androchef.presentation.movielist.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.androchef.domain.executor.PostExecutionThread
import com.androchef.domain.executor.ThreadExecutor
import com.androchef.domain.interactor.movielist.BookmarkMovieUseCase
import com.androchef.domain.interactor.movielist.GetMovieListUseCase
import com.androchef.domain.interactor.movielist.UnBookmarkMovieUseCase
import com.androchef.domain.models.movies.Movie
import com.androchef.domain.repositories.MovieRepository
import com.androchef.presentation.factory.movies.PresentationMovieFactory
import com.androchef.presentation.movielist.mapper.MovieMapper
import com.androchef.presentation.movielist.models.MovieView
import com.androchef.presentation.schedulers.TestingPostExecutionThread
import com.androchef.presentation.schedulers.TestingThreadExecutor
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class MovieListViewModelTest {

    @get:Rule
    var instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var stateObserver: Observer<MovieState>

    private var movieMapper = MovieMapper()

    private lateinit var getMovieListUseCase: GetMovieListUseCase

    private lateinit var bookmarkMovieUseCase: BookmarkMovieUseCase

    private lateinit var unBookmarkMovieUseCase: UnBookmarkMovieUseCase

    private lateinit var movieListViewModel: MovieListViewModel

    private lateinit var threadExecutor: ThreadExecutor

    private lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        setUpThreadForRxJava()
        setUpUseCases()
        setUpViewModel()
    }

    private fun setUpThreadForRxJava() {
        threadExecutor = TestingThreadExecutor()
        postExecutionThread = TestingPostExecutionThread()
    }

    private fun setUpUseCases() {
        getMovieListUseCase =
            GetMovieListUseCase(movieRepository, threadExecutor, postExecutionThread)
        bookmarkMovieUseCase =
            BookmarkMovieUseCase(movieRepository, threadExecutor, postExecutionThread)
        unBookmarkMovieUseCase =
            UnBookmarkMovieUseCase(movieRepository, threadExecutor, postExecutionThread)
    }

    private fun setUpViewModel() {
        movieListViewModel = MovieListViewModel(
            movieMapper,
            getMovieListUseCase,
            bookmarkMovieUseCase,
            unBookmarkMovieUseCase
        )
        movieListViewModel.stateObservable.observeForever(stateObserver)
    }

    @Test
    fun fetchMoviesList_returnsEmpty() {
        // Arrange
        stubFetchMovies(Single.just(listOf()))

        // Act
        movieListViewModel.fetchMoviesList()

        // Assert
        verify(stateObserver).onChanged(MovieState.Loading)
        verify(stateObserver).onChanged(MovieState.MovieListSuccess(listOf()))
    }

    @Test
    fun fetchMoviesList_returnsError() {
        // Arrange
        stubFetchMovies(Single.error(TestingException(TestingException.GENERIC_EXCEPTION_MESSAGE)))

        // Act
        movieListViewModel.fetchMoviesList()

        // Assert
        verify(stateObserver).onChanged(MovieState.Loading)
        verify(stateObserver).onChanged(MovieState.Error(TestingException.GENERIC_EXCEPTION_MESSAGE))
    }

    @Test
    fun fetchMoviesList_returnsData() {
        // Arrange
        val listOfMovies = PresentationMovieFactory.generateListOfMovies(10)
        val listOfViews = mutableListOf<MovieView>()
        listOfMovies.forEach {
            listOfViews.add(movieMapper.mapToView(it))
        }
        stubFetchMovies(Single.just(listOfMovies))

        // Act
        movieListViewModel.fetchMoviesList()

        // Assert
        verify(stateObserver).onChanged(MovieState.Loading)
        verify(stateObserver).onChanged(MovieState.MovieListSuccess(listOfViews))
    }

    @Test
    fun bookmarkMovie_error() {
        // Arrange
        val listOfMovies = PresentationMovieFactory.generateListOfMovies(10)

        val movieToBookmark = listOfMovies[0] // taking first movie and making it to as Bookmarked.
        movieToBookmark.isBookMarked = true
        val movieView = movieMapper.mapToView(movieToBookmark) // mapping to movieView

        stubFetchMovies(Single.just(listOfMovies))
        stubBookMarkMovie(movieToBookmark.id!!, Completable.error(TestingException()))

        // Act
        movieListViewModel.onBookmarkStatusChanged(movieView)

        // Assert
        verify(stateObserver).onChanged(MovieState.Error(TestingException.GENERIC_EXCEPTION_MESSAGE))
    }

    @Test
    fun bookmarkMovie_completes() {
        // Arrange
        val listOfMovies = PresentationMovieFactory.generateListOfMovies(10)

        val movieToBookmark = listOfMovies[0] // taking first movie and making it to as Bookmarked.
        movieToBookmark.isBookMarked = true
        val movieView = movieMapper.mapToView(movieToBookmark) // mapping to movieView

        stubFetchMovies(Single.just(listOfMovies))
        stubBookMarkMovie(movieToBookmark.id!!, Completable.complete())

        // Act
        movieListViewModel.onBookmarkStatusChanged(movieView)

        // Assert
        verify(stateObserver).onChanged(MovieState.BookmarkChangeSuccess)
    }

    @Test
    fun unBookmarkMovie_error() {
        // Arrange
        val listOfMovies = PresentationMovieFactory.generateListOfMovies(10)

        val movieToUnBookmark = listOfMovies[0] // taking first movie and making it to as UnBookmark.
        movieToUnBookmark.isBookMarked = false
        val movieView = movieMapper.mapToView(movieToUnBookmark) // mapping to movieView

        stubFetchMovies(Single.just(listOfMovies))
        stubUnBookMarkMovie(movieToUnBookmark.id!!, Completable.error(TestingException()))

        // Act
        movieListViewModel.onBookmarkStatusChanged(movieView)

        // Assert
        verify(stateObserver).onChanged(MovieState.Error(TestingException.GENERIC_EXCEPTION_MESSAGE))
    }

    @Test
    fun unBookmarkMovie_completes() {
        // Arrange
        val listOfMovies = PresentationMovieFactory.generateListOfMovies(10)

        val movieToUnBookmark = listOfMovies[0] // taking first movie and making it to as UnBookmark.
        movieToUnBookmark.isBookMarked = false
        val movieView = movieMapper.mapToView(movieToUnBookmark) // mapping to movieView

        stubFetchMovies(Single.just(listOfMovies))
        stubUnBookMarkMovie(movieToUnBookmark.id!!, Completable.complete())

        // Act
        movieListViewModel.onBookmarkStatusChanged(movieView)

        // Assert
        verify(stateObserver).onChanged(MovieState.BookmarkChangeSuccess)
    }

    /**
     * Stub Helpers Methods
     */
    private fun stubFetchMovies(single: Single<List<Movie>>) {
        `when`(getMovieListUseCase.buildUseCaseObservable())
            .thenReturn(single)
    }

    private fun stubBookMarkMovie(movieId: Long, completable: Completable) {
        `when`(bookmarkMovieUseCase.buildUseCaseObservable(movieId))
            .thenReturn(completable)
    }

    private fun stubUnBookMarkMovie(movieId: Long, completable: Completable) {
        `when`(unBookmarkMovieUseCase.buildUseCaseObservable(movieId))
            .thenReturn(completable)
    }

    class TestingException(message: String = GENERIC_EXCEPTION_MESSAGE) : Exception(message) {
        companion object {
            const val GENERIC_EXCEPTION_MESSAGE = "Something error came while executing"
        }
    }
}

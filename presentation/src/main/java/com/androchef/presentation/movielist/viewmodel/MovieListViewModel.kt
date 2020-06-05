package com.androchef.presentation.movielist.viewmodel

import androidx.lifecycle.MutableLiveData
import com.androchef.domain.interactor.movielist.BookmarkMovieUseCase
import com.androchef.domain.interactor.movielist.GetMovieListUseCase
import com.androchef.domain.interactor.movielist.UnBookmarkMovieUseCase
import com.androchef.domain.models.movies.Movie
import com.androchef.presentation.base.BaseViewModel
import com.androchef.presentation.movielist.mapper.MovieMapper
import com.androchef.presentation.movielist.models.MovieView
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver

class MovieListViewModel constructor(
    private val movieMapper: MovieMapper,
    private val getMovieListUseCase: GetMovieListUseCase,
    private val bookmarkMovieUseCase: BookmarkMovieUseCase,
    private val unBookmarkMovieUseCase: UnBookmarkMovieUseCase
) : BaseViewModel<MovieState>() {

    private var state: MovieState = MovieState.Init
        set(value) {
            field = value
            publishState(value)
        }

    fun fetchMoviesList() {
        state = MovieState.Loading
        val singleObserver = object : DisposableSingleObserver<List<Movie>>() {
            override fun onSuccess(t: List<Movie>) {
                state = MovieState.MovieListSuccess(t.map { movieMapper.mapToView(it) })
            }

            override fun onError(e: Throwable) {
                state = MovieState.Error(e.localizedMessage)
            }
        }
        getMovieListUseCase.execute(singleObserver)
    }

    fun onBookmarkStatusChanged(movieView: MovieView) {
        val singleObserver = object : DisposableCompletableObserver() {

            override fun onComplete() {
                state = MovieState.BookmarkChangeSuccess
            }

            override fun onError(e: Throwable) {
                state = MovieState.Error(e.localizedMessage)
            }
        }
        if (movieView.isBookMarked)
            bookmarkMovieUseCase.execute(singleObserver, movieView.id)
        else
            unBookmarkMovieUseCase.execute(singleObserver, movieView.id)
    }

    override val stateObservable: MutableLiveData<MovieState> by lazy {
        MutableLiveData<MovieState>()
    }
}

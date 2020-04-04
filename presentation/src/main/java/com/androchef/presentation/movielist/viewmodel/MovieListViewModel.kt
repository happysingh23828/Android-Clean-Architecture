package com.androchef.presentation.movielist.viewmodel

import androidx.lifecycle.MutableLiveData
import com.androchef.domain.interactor.movielist.GetMovieListUseCase
import com.androchef.domain.models.movies.Movie
import com.androchef.presentation.base.BaseViewModel
import com.androchef.presentation.movielist.mapper.MovieMapper
import io.reactivex.observers.DisposableSingleObserver

class MovieListViewModel constructor(
    private val movieMapper: MovieMapper,
    private val getMovieListUseCase: GetMovieListUseCase
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
                state = MovieState.MovieList(t.map { movieMapper.mapToView(it) })
            }

            override fun onError(e: Throwable) {
                state = MovieState.Error(e.localizedMessage)
            }
        }
        getMovieListUseCase.execute(singleObserver)
    }

    override val stateObservable: MutableLiveData<MovieState> by lazy {
        MutableLiveData<MovieState>()
    }
}
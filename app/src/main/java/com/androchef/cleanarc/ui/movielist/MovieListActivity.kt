package com.androchef.cleanarc.ui.movielist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.androchef.cleanarc.MainApplication
import com.androchef.cleanarc.R
import com.androchef.cleanarc.extension.createFactory
import com.androchef.cleanarc.extension.gone
import com.androchef.cleanarc.extension.visible
import com.androchef.cleanarc.ui.movielist.adapter.MovieListAdapter
import com.androchef.domain.interactor.movielist.BookmarkMovieUseCase
import com.androchef.domain.interactor.movielist.GetMovieListUseCase
import com.androchef.domain.interactor.movielist.UnBookmarkMovieUseCase
import com.androchef.presentation.movielist.mapper.MovieMapper
import com.androchef.presentation.movielist.models.MovieView
import com.androchef.presentation.movielist.viewmodel.MovieListViewModel
import com.androchef.presentation.movielist.viewmodel.MovieState
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_movie_list.*
import kotlinx.android.synthetic.main.layout_error_state.view.*

class MovieListActivity : AppCompatActivity(), MovieListAdapter.OnBookmarkClickedListener {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MovieListActivity::class.java))
        }
    }

    lateinit var movieListViewModel: MovieListViewModel

    private var movieListAdapter: MovieListAdapter? = null

    @Inject
    lateinit var movieMapper: MovieMapper

    @Inject
    lateinit var getMovieListUseCase: GetMovieListUseCase

    @Inject
    lateinit var bookmarkMovieUseCase: BookmarkMovieUseCase

    @Inject
    lateinit var unBookmarkMovieUseCase: UnBookmarkMovieUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        init()
        onClicks()
        setRecyclerView()
        setObservers()
    }

    private fun init() {
        MainApplication.appComponent().inject(this)
        val factory = MovieListViewModel(
            movieMapper,
            getMovieListUseCase,
            bookmarkMovieUseCase,
            unBookmarkMovieUseCase
        ).createFactory()
        movieListViewModel =
            ViewModelProviders.of(this, factory).get(MovieListViewModel::class.java)
    }

    private fun setObservers() {
        movieListViewModel.stateObservable.observe(this, Observer {
            updateView(it)
        })
        fetchMovies()
    }

    private fun setRecyclerView() {
        movieListAdapter = MovieListAdapter()
        movieListAdapter?.setBookMarkChangeListener(this)
        movieListRecyclerView.layoutManager = LinearLayoutManager(this)
        movieListRecyclerView.adapter = movieListAdapter
    }

    private fun fetchMovies() {
        movieListViewModel.fetchMoviesList()
    }

    private fun updateView(movieState: MovieState) {
        when (movieState) {
            MovieState.Loading -> showLoading()
            is MovieState.Error -> showErrorLayout(movieState.message)
            is MovieState.MovieListSuccess -> showMovieListToUI(movieState.listOfMovieViews)
        }
    }

    private fun onClicks() {
        layoutError.btnRetryButton.setOnClickListener {
            fetchMovies()
        }

        rootRecyclerView.setOnRefreshListener {
            fetchMovies()
        }
    }

    private fun showMovieListToUI(listOfMovieViews: List<MovieView>) {
        hideLoading()
        movieListAdapter?.refreshList(listOfMovieViews)
        layoutError.gone()
        movieListRecyclerView.visible()
    }

    private fun showErrorLayout(errorMessage: String) {
        hideLoading()
        movieListRecyclerView.gone()
        layoutError.tvErrorMessage.text = errorMessage
        layoutError.visible()
    }

    private fun showLoading() {
        rootRecyclerView.isRefreshing = true
        movieListRecyclerView.gone()
        layoutError.gone()
    }

    private fun hideLoading() {
        rootRecyclerView.isRefreshing = false
    }

    override fun onBookmarkChanged(movieView: MovieView) {
        movieListViewModel.onBookmarkStatusChanged(movieView)
    }
}

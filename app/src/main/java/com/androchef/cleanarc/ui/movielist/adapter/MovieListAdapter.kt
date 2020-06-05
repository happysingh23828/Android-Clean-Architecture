package com.androchef.cleanarc.ui.movielist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androchef.cleanarc.R
import com.androchef.presentation.movielist.models.MovieView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_single_item_movie_list.view.*

class MovieListAdapter(
    private var bookmarkClickedListener: OnBookmarkClickedListener? = null
) :
    RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    private val listOfMovieView: MutableList<MovieView> = mutableListOf()

    fun refreshList(listOfMovieView: List<MovieView>) {
        this.listOfMovieView.clear()
        this.listOfMovieView.addAll(listOfMovieView)
        notifyDataSetChanged()
    }

    fun setBookMarkChangeListener(onBookmarkClickedListener: OnBookmarkClickedListener) {
        this.bookmarkClickedListener = onBookmarkClickedListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_single_item_movie_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listOfMovieView.size
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.bind(listOfMovieView[position])
    }

    inner class MovieListViewHolder(private val mView: View) : RecyclerView.ViewHolder(mView) {

        fun bind(movieView: MovieView) {
            mView.tvMovieName.text = movieView.movieName
            mView.tvVotes.text = movieView.voteAverage.toString()
            mView.ivBookmark.isSelected = movieView.isBookMarked
            movieView.profilePath?.let {
                if (it.isNotBlank())
                    Picasso.get().load(it).into(mView.ivImageView)
            }
            onClicks(movieView)
        }

        private fun onClicks(movieView: MovieView) {
            mView.ivBookmark.setOnClickListener {
                it.isSelected = movieView.isBookMarked.not()
                movieView.isBookMarked = it.isSelected
                bookmarkClickedListener?.onBookmarkChanged(movieView)
            }
        }
    }

    interface OnBookmarkClickedListener {
        fun onBookmarkChanged(movieView: MovieView)
    }
}

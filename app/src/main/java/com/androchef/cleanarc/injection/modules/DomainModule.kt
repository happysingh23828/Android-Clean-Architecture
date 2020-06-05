package com.androchef.cleanarc.injection.modules

import com.androchef.data.MoviesDataRepository
import com.androchef.data.executor.JobExecutor
import com.androchef.domain.CompletableUseCase
import com.androchef.domain.SingleUseCase
import com.androchef.domain.executor.ThreadExecutor
import com.androchef.domain.interactor.moviecredits.GetMovieCreditsUseCase
import com.androchef.domain.interactor.movielist.BookmarkMovieUseCase
import com.androchef.domain.interactor.movielist.GetMovieListUseCase
import com.androchef.domain.interactor.movielist.UnBookmarkMovieUseCase
import com.androchef.domain.models.movies.Movie
import com.androchef.domain.models.movies.MovieCredits
import com.androchef.domain.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideMovieRepository(moviesDataRepository: MoviesDataRepository): MovieRepository {
        return moviesDataRepository
    }

    @Provides
    @Singleton
    fun provideGetMovieListUseCase(getMovieListUseCase: GetMovieListUseCase): SingleUseCase<Void, List<Movie>> {
        return getMovieListUseCase
    }

    @Provides
    @Singleton
    fun provideGetMovieCreditsUseCase(getMovieCreditsUseCase: GetMovieCreditsUseCase):
            SingleUseCase<GetMovieCreditsUseCase.Params, MovieCredits> {
        return getMovieCreditsUseCase
    }

    @Provides
    @Singleton
    fun provideBookmarkMovieUseCase(bookmarkMovieUseCase: BookmarkMovieUseCase): CompletableUseCase<Long> {
        return bookmarkMovieUseCase
    }

    @Provides
    @Singleton
    fun provideUnBookmarkMovieUseCase(unBookmarkMovieUseCase: UnBookmarkMovieUseCase): CompletableUseCase<Long> {
        return unBookmarkMovieUseCase
    }

    @Provides
    @Singleton
    fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }
}

package com.androchef.cleanarc.injection.modules

import com.androchef.data.MoviesDataRepository
import com.androchef.domain.interactor.BaseUseCase
import com.androchef.domain.interactor.moviecredits.GetMovieCreditsUseCase
import com.androchef.domain.interactor.movielist.GetMovieListUseCase
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
    fun provideGetMovieListUseCase(getMovieListUseCase: GetMovieListUseCase): BaseUseCase<Void, List<Movie>> {
        return getMovieListUseCase
    }

    @Provides
    @Singleton
    fun provideGetMovieCreditsUseCase(getMovieCreditsUseCase: GetMovieCreditsUseCase) :
            BaseUseCase<GetMovieCreditsUseCase.Params, MovieCredits> {
        return getMovieCreditsUseCase
    }

}
package com.androchef.cleanarc.injection.modules

import android.app.Application
import com.androchef.cache.MoviesCacheImp
import com.androchef.cache.db.MovieDatabase
import com.androchef.data.repository.MoviesCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides
    @Singleton
    fun provideMovieDataBase(application: Application): MovieDatabase {
        return MovieDatabase.getInstance(application)
    }

    @Provides
    @Singleton
    fun provideMovieCache(moviesCacheImp: MoviesCacheImp): MoviesCache {
        return moviesCacheImp
    }
}

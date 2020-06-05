package com.androchef.data.store

import com.androchef.data.repository.MovieDataStore
import com.androchef.data.repository.MoviesCache
import javax.inject.Inject

open class MovieDataStoreFactory @Inject constructor(
    private val moviesCache: MoviesCache,
    private val movieCacheDataStore: MovieCacheDataStore,
    private val movieRemoteDataStore: MovieRemoteDataStore
) {

    open fun getDataStore(isCached: Boolean): MovieDataStore {
        if (isCached && !moviesCache.isExpired()) {
            return getCacheDataStore()
        }
        return getRemoteDataStore()
    }

    fun getCacheDataStore(): MovieDataStore {
        return movieCacheDataStore
    }

    fun getRemoteDataStore(): MovieDataStore {
        return movieRemoteDataStore
    }
}

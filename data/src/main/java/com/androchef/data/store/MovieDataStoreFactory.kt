package com.androchef.data.store

import javax.inject.Inject

class MovieDataStoreFactory @Inject constructor(
    private val movieCacheDataStore: MovieCacheDataStore,
    private val movieRemoteDataStore: MovieRemoteDataStore
) {
    fun getCacheDataStore(): MovieCacheDataStore {
        return movieCacheDataStore
    }

    fun getRemoteDataStore(): MovieRemoteDataStore {
        return movieRemoteDataStore
    }
}
package com.androchef.data.store

class MovieDataStoreFactory constructor(
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